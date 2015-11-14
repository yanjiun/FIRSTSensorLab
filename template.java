/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1234.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends SampleRobot {
    
    /*==== Robot Components ====
    What parts the robot has
    */
    
    /*
    Drive train: this is what makes it move
    */
   RobotDrive drivetrain = new RobotDrive(0, 1);
   DigitalInput frontSwitch = new DigitalInput(0);
   DigitalInput backSwitch = newDigitalInput(1);
   AnalogChannel frontRangeFinder = new AnalogChannel(0);
   AnalogChannel backRangeFinder = new AnalogChannel(1);
   
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
    	System.out.println("This is autonomous---"+frontSwitch.get());
    	drivetrain.setSafetyEnabled(false);
        
        exampleOne();
    }

    /**
     * WHERE SOLUTIONS TO EXERCISES and Examples live
     */
    
    private void exampleOne() {
        //If we are driving forward AND the front switch is pressed, drive backwards
        double speed = 0.2;
        drivetrain.drive(speed, 0); //start driving
        System.out.println("Driving forward");
        while (isEnabled() && isAutonomous()) {

        	if (!frontSwitch.get()){ //If the front switch was pressed
        		System.out.println("Driving backward");
        		drivetrain.drive(-speed,0); //Back away
        		Timer.delay(2.0); // for 2 seconds
        		System.out.println("Driving forward");
        		drivetrain.drive(speed, 0); // Start driving again
        	    }
        }
    }

    private void exercise_1()
    {
  	//If we are driving forward AND the front switch is pressed, drive backwards.
  	// Keep driving back till back switch is pressed, then drive forwards again!
    }
    
    private void exercise_1_1()
    {
  	//If we are driving forward AND the front switch is pressed, drive backwards.
  	// Keep driving back till back switch is pressed, then drive forwards again!
    }
     
     private double getFrontDistance(){
     	// get distance based on front range finder
     	return frontRangeFiner.getVoltage() * 1000 / 0.98;
     }
     
     private double getBackDistance(){
     	// get distance based on back range finder
     	return backRangeFiner.getVoltage() * 1000 / 0.98;
     }
     
     private double exampleTwo(){
     	// while we are less than 5 inches away from wall
     	  driveTrain.drive(0.2, 0); 

	      while (isEnabled() && isAutonomous()) {
		      if (getFrontDistance() < 5) {				
			      driveTrain.drive(-0.2, 0); 
			      Timer.delay(2.0);          
			      driveTrain.drive(0, 0.2);
			      Timer.delay(2.0);
			      driveTrain.drive(0.2, 0);
 		      }
	        }
      }
     
     private double exercise_3_0(){
     	// imagine a robot between two walls. write a program that stops the robot midway between 2 parallel walls
     }
     
    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    	System.out.println("This is test---"+frontSwitch.get());
    
    }
    

}
