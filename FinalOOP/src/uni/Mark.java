package uni;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mark implements Comparable<Mark>  {

    private double digitMark;
    private String letterMark;
    private double firstAttMark;
    private double secondAttMark;
    private double finalExamMark;
    
    String[] letterMarks = {"F","F","F","F","F","F","F","F","F","F","D","D+","C-","C","C+","B-","B","B+","A-","A"};
    Map<String, Double> gpaMarks = Stream.of(new Object[][] { 
        { "A", 4 }, 
        { "A-", 3.7 },
        { "B+", 3.3 }, 
        { "B", 3.0 }, 
        { "B-", 2.7 }, 
        { "C+", 2.3 }, 
        { "C", 2 }, 
        { "C-", 1.7 }, 
        { "D+", 1.3 }, 
        { "D", 1.0 }, 
        { "D-", 0.7 }, 
        { "F", 0 }, 
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Double) data[1]));
    
    public double getGpaMark() {
    	return gpaMarks.get(this.letterMark);
    }

    public double getDigitMark() {
        return this.digitMark;
    }

    public void calculateDigitMark() {
        this.digitMark = this.firstAttMark + this.secondAttMark + this.finalExamMark;
    }
  
    public String getLetterMark() {
        return this.letterMark;
    }

    public void calculateLetterMark() {
        calculateDigitMark();
        this.letterMark = letterMarks[(int) Math.round(this.digitMark/5)];
    }

    public double getFirstAttMark() {
        return this.firstAttMark;
    }

	
    public void setFirstAttMark(double mark) {
    	this.firstAttMark = mark;
    }

    public double getSecondAttMark() {
        return this.secondAttMark;
    }

    public void setSecondAttMark(double mark) {
        this.secondAttMark = mark;
    }

    public double getFinalExamMark() {
        return this.finalExamMark;
    }

    public void setFinalExamMark(double mark) {
    	this.finalExamMark = mark;
    }

    public int compareTo(Mark m) {
        if(this.digitMark > m.digitMark) return 1;
        else if(this.digitMark < m.digitMark) return -1;
        
        if(this.digitMark > m.digitMark) return 1;
        else if(this.digitMark < m.digitMark) return -1;
        
        if(this.digitMark > m.digitMark) return 1;
        else if(this.digitMark < m.digitMark) return -1;
        
        if(this.digitMark > m.digitMark) return 1;
        else if(this.digitMark < m.digitMark) return -1;
        
        return 0;
    }

    public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		
		Mark m = (Mark)obj;
		return this.firstAttMark == m.firstAttMark && this.secondAttMark == m.secondAttMark && this.finalExamMark == m.finalExamMark;
	}

    public int hashCode() {
        return Objects.hash(digitMark, firstAttMark, secondAttMark, finalExamMark);
    }

    public String toString() {
        return "First attestation mark = " + this.firstAttMark + " Second attestation mark = " + this.secondAttMark + " Final exam mark = " + this.finalExamMark
        		+ "\n Course mark = " + this.digitMark + " Letter mark is " + this.letterMark;
    }
}
