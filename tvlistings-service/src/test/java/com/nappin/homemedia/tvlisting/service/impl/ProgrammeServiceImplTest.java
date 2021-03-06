package com.nappin.homemedia.tvlisting.service.impl;

import com.nappin.homemedia.tvlisting.delegate.ProgrammeListingDelegate;
import com.nappin.homemedia.tvlisting.model.Channel;
import com.nappin.homemedia.tvlisting.service.ProgrammeService;
import org.junit.Test;
import org.springframework.boot.actuate.metrics.CounterService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Tests the <code>ProgrammeServiceImpl</code> class.
 */
public class ProgrammeServiceImplTest {

    /**
     * Tests invocation of the delegate.
     */
    @Test
    public void happyPath() {
        CounterService counter = mock(CounterService.class);
        ProgrammeListingDelegate delegate = mock(ProgrammeListingDelegate.class);
        ProgrammeService service = new ProgrammeServiceImpl(counter, delegate);

        List<Channel> result = new ArrayList<>();
        result.add(new Channel(10L, "channel #1"));
        given(delegate.getProgrammeListing()).willReturn(result);

        List<Channel> actual = service.getProgrammes();
        assertEquals("Wrong results returned", result, actual);
    }
}
