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
   
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
    	System.out.println("This is autonomous---"+frontSwitch.get());
    	drivetrain.setSafetyEnabled(false);
        
        double speed = 0.2;
        drivetrain.drive(speed, 0); //start driving
        System.out.println("Driving forward");
        while (isEnabled() && isAutonomous()) {
            //If we are driving forward AND the front switch is pressed
            //drive backwards
        	if (!frontSwitch.get()){ //If the switch was pressed
        		System.out.println("driving backward");
        		drivetrain.drive(-speed,0); //Back away
        		Timer.delay(2.0); // for 2 seconds
        		System.out.println("driving forward");
        		drivetrain.drive(speed, 0); // Start driving again
        	}
        }
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
    
    /*
    public void robotInit() {
    	System.out.println("Robot control");
    	frontSwitch = new DigitalInput(1);
    }*/
    
    /*public static void main()
    {
    	System.out.println("In main--");
    	Robot bot = new Robot();
    	bot.test();
    }*/
}
