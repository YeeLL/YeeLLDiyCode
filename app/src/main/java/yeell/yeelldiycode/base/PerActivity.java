package yeell.yeelldiycode.base;

/**
 * Created by yee on 11/23/16.
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
