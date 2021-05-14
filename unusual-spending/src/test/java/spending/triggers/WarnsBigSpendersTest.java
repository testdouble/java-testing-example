package spending.triggers;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import spending.triggers.warns.ComposesBody;
import spending.triggers.warns.ComposesSubject;
import spending.triggers.warns.EmailsUserWrapper;
import spending.values.BigSpend;

@RunWith(MockitoJUnitRunner.class)
public class WarnsBigSpendersTest {

	@InjectMocks
	WarnsBigSpenders subject;

	@Mock
	ComposesSubject composesSubject;

	@Mock
	ComposesBody composesBody;

	@Mock
	EmailsUserWrapper emailsUserWrapper;

	@Test
	public void test() {
		long userId = 38;
		Collection<BigSpend> bigSpends = Arrays.asList(new BigSpend(null, null, null));
		when(composesSubject.compose(bigSpends)).thenReturn("a subject");
		when(composesBody.compose(bigSpends)).thenReturn("a body");

		subject.warn(userId, bigSpends);

		verify(emailsUserWrapper).email(userId, "a subject", "a body");
	}
}