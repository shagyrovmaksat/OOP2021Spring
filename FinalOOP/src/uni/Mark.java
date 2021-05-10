package uni;

import java.util.Objects;

public class Mark implements Comparable<Mark>  {

    private double digitMark;
    private LetterMark letterMark;
    private double firstAttMark;
    private double secondAttMark;
    private double finalExamMark;

    public double getDigitMark() {
        return this.digitMark;
    }

    public void calculateDigitMark() {
        this.digitMark = this.firstAttMark + this.secondAttMark + this.finalExamMark;
    }

    public LetterMark getLetterMark() {
        return this.letterMark;
    }

    public void calculateLetterMark() {

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