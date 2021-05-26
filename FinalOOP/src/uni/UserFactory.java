package uni;

public class UserFactory {

	public User getUser(UserType userType) {
		User user = null;
		switch (userType) {
		case ADMIN:
			user = new Admin();
			break;
		case LIBRARIAN:
			user = new Librarian();
			break;
		case MANAGER:
			user = new Manager();
			break;
		case STUDENT:
			user = new Student();
			break;
		case TEACHER:
			user = new Teacher();
			break;
		default:
			break;
		}
		return user;
	}
}
