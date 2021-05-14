package spending.triggers;

import java.util.Collection;

import spending.triggers.warns.ComposesBody;
import spending.triggers.warns.ComposesSubject;
import spending.triggers.warns.EmailsUserWrapper;
import spending.values.BigSpend;

public class WarnsBigSpenders {

	ComposesSubject composesSubject = new ComposesSubject();
	ComposesBody composesBody = new ComposesBody();
	EmailsUserWrapper emailsUserWrapper = new EmailsUserWrapper();

	public void warn(long userId, Collection<BigSpend> bigSpends) {
		emailsUserWrapper.email(userId, composesSubject.compose(bigSpends), composesBody.compose(bigSpends));
	}
}
