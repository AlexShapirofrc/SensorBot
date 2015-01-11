
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
public class Robot extends IterativeRobot {
	Encoder encodel;
	Encoder encoder;
	//left and right encoders
	Talon tall;
	Talon talr;
	//left and right talons
	AnalogInput ultra;
	Gyro gyro;
	double range = ultra.getVoltage();
	//gets object distance with voltage
	double angle = gyro.getAngle();
	//gets angle of robot from gyro
	double leftwheelrate = encodel.getRate();
	double rightwheelrate = encoder.getRate();
	//gets rotation rate from both wheels
	Timer time;
	double timepassed = time.get();
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	ultra = new AnalogInput(0);
    	tall = new Talon(0);
    	talr = new Talon(1);
    	gyro = new Gyro(1);
    	encodel = new Encoder(4,5);
    	encoder = new Encoder(2,3);
    	time = new Timer();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	System.out.println("voltage is" + range + "angle is" + angle);
    	//prints out both distance from object and angle
    	if(range <= 500){
    		tall.set(0.2);
    		talr.set(0.8);
    	}else{
        tall.set(0.5);
        talr.set(0.5);
        //if range is less than 500 millimeters, turn left, else go forward 1/2 speed
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
