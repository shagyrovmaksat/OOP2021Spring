package uni;

public class UserFactory {

	public User getUser(UserType userType, String name, String surname, String password) {
		User user = null;
		switch (userType) {
		case ADMIN:
			user = new Admin(name, surname, password);
			break;
		case LIBRARIAN:
			user = new Librarian(name, surname, password);
			break;
		case MANAGER:
			user = new Manager(name, surname, password);
			break;
		case STUDENT:
			user = new Student(name, surname, password);
			break;
		case TEACHER:
			user = new Teacher(name, surname, password);
			break;
		default:
			break;
		}
		return user;
	}
}
