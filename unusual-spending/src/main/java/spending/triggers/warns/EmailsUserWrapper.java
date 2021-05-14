package spending.triggers.warns;

import spending.EmailsUser;

public class EmailsUserWrapper {

	public void email(long userId, String subject, String body) {
		EmailsUser.email(userId, subject, body);
	}

}
