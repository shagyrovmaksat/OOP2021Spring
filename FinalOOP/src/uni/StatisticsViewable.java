package uni;

public interface StatisticsViewable {
	
	public default double getMaxGrade(Course course) {
		return 0;
	}
	
	public default double getMinGrade(Course course) {
		return 0;	
	}
	
	public default double getAvgGrade(Course course) {
		return 0;
	}
}
