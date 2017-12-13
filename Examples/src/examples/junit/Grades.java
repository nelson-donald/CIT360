/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.junit;

/**
 *
 * @author neldo
 */
public class Grades {
    
    private int _grade = 0;
    
    public Grades(int val)
    {
        this._grade=val;
    }
    
    public String print()
    {
        if(_grade >= 90)
            return "A";
        else if(_grade >= 80)
            return "B";
        else if(_grade >= 70)
            return "C";
        else if(_grade >= 60)
            return "D";
        else
            return "F";
    }

    public int getGrade() {
        return _grade;
    }

    public void setGrade(int _grade) {
        this._grade = _grade;
    }
    
    
}
