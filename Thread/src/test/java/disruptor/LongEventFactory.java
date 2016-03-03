package disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Fansghuai on 2016/1/27.
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
