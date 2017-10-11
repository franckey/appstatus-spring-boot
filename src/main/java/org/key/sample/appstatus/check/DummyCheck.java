package org.key.sample.appstatus.check;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

import net.sf.appstatus.core.check.AbstractCheck;
import net.sf.appstatus.core.check.CheckResultBuilder;
import net.sf.appstatus.core.check.ICheck;
import net.sf.appstatus.core.check.ICheckResult;

/**
 * IResettableCheck will be available in v2.1.
 */
public class DummyCheck extends AbstractCheck implements ICheck /* IResettableCheck */ {

    private AtomicBoolean error = new AtomicBoolean(false);

    @Override
    public ICheckResult checkStatus(Locale locale) {
        CheckResultBuilder result = result(this).description("Dummy description");

        if (error.get()) {
            result.code(ICheckResult.ERROR).fatal();
        } else {
            result.code(ICheckResult.OK);
        }

        return result.build();
    };

    /**
     * available in v2.1
     */
    // public void reset() {
    // error.set(!error.get());
    // }

    @Override
    public String getGroup() {
        return "Dummy";
    }

    @Override
    public String getName() {
        return "Dummy name";
    }

}
