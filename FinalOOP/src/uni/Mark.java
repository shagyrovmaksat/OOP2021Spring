package uni;

import java.util.Objects;

public class Mark implements Comparable<Mark>  {

    private double digitMark;
    private double attTotalMark;
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
        calculateDigitMark();
        calculateTotalAtt();

        if(attTotalMark < 30){
            letterMark = LetterMark.F;
        } else if(finalExamMark < 20){
            letterMark = LetterMark.FX;
        }else if(digitMark >= 50 && digitMark < 55){
            letterMark = LetterMark.D;
        }else if(digitMark >= 55 && digitMark < 60){
            letterMark = LetterMark.Dplus;
        }else if(digitMark >= 60 && digitMark < 65){
            letterMark = LetterMark.Cminus;
        }else if(digitMark >= 65 && digitMark < 70){
            letterMark = LetterMark.C;
        }else if(digitMark >= 70 && digitMark < 75){
            letterMark = LetterMark.Cplus;
        }else if(digitMark >= 75 && digitMark < 80){
            letterMark = LetterMark.Bminus;
        }else if(digitMark >= 80 && digitMark < 85){
            letterMark = LetterMark.B;
        }else if(digitMark >= 85 && digitMark < 90){
            letterMark = LetterMark.Bplus;
        }else if(digitMark >= 90 && digitMark < 95){
            letterMark = LetterMark.Aminus;
        }else if(digitMark >= 95 && digitMark <= 100){
            letterMark = LetterMark.A;
        }
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

    public void calculateTotalAtt(){
        this.attTotalMark = this.firstAttMark + this.secondAttMark;
    }

    public double getAttTotalMark() {
        return this.attTotalMark;
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
