/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import javax.ejb.Stateless;

/**
 *
 * @author deshmukh_sg
 */
@Stateless
public class CCBean {

    public CCBean(){}
public double r2Dollor(double r){ return r/65.65; }
public double d2Rupees(double d){ return d*65.65; }
}
