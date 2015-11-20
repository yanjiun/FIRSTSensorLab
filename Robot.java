/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1234.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
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
   RobotDrive driveTrain = new RobotDrive(0, 1);
   DigitalInput frontSwitch = new DigitalInput(0);
   DigitalInput backSwitch = new DigitalInput(1);
   AnalogInput frontRangeFinder = new AnalogInput(0);
   AnalogInput backRangeFinder = new AnalogInput(1);
   
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
    	System.out.println("This is autonomous---"+frontSwitch.get());
    	driveTrain.setSafetyEnabled(false);
        
        exampleOne();
        //exercise_1();
        //exercise_1_1();
        //exampleTwo();
        //exercise_3_0();
    }

    /**
     * WHERE SOLUTIONS TO EXERCISES and Examples live
     */
    
    private void exampleOne() {
        //If we are driving forward AND the front switch is pressed, drive backwards
        double speed = 0.2;
        driveTrain.drive(speed, 0); //start driving
        System.out.println("Driving forward");
        while (isEnabled() && isAutonomous()) {

        	if (!frontSwitch.get()){ //If the front switch was pressed
        		System.out.println("Driving backward");
        		driveTrain.drive(-speed,0); //Back away
        		Timer.delay(2.0); // for 2 seconds
        		System.out.println("Driving forward");
        		driveTrain.drive(speed, 0); // Start driving again
        	    }
        }
    }

    private void exercise_1()
    {
	//If we are driving forward AND the front switch is pressed, drive backwards.
	// Keep driving back till back switch is pressed, then drive forwards again!
        double speed = 0.2;
        driveTrain.drive(speed, 0); //start driving
        System.out.println("Driving forward");
        while (isEnabled() && isAutonomous()) {

        	if (!frontSwitch.get()){ //If the front switch was pressed
        		System.out.println("Driving backward");
			driveTrain.drive(-speed,0); //Back away
        	}
		else if (!backSwitch.get()) { //If the back switch was pressed
			System.out.println("Driving forward");
			driveTrain.drive(speed,0); //Move forward again!	
		}
        }

    }
    
    private void exercise_1_1()
    {
	//If we are driving forward AND the front switch is pressed, turn right and drive backwards.
	//If we are driving backward AND the back switch is pressed, turn left and drive forwards.
        double speed = 0.2;
        driveTrain.drive(speed, 0); //start driving
        System.out.println("Driving forward");
        while (isEnabled() && isAutonomous()) {

        	if (!frontSwitch.get()){ //If the front switch was pressed
        		System.out.println("Driving backward");
			driveTrain.drive(-speed,0); //Back away
			Timer.delay(2.0); // for 2 seconds
			System.out.println("Turning right");
			driveTrain.drive(-speed,1); //Turn right 
			System.out.println("Driving backward");
			driveTrain.drive(-speed,0); //Back away
			
        	}
		else if (!backSwitch.get()) { //If the back switch was pressed
			System.out.println("Driving forward");
			driveTrain.drive(speed,0);//Move forward
			Timer.delay(2.0); // for 2 seconds
			System.out.println("Turning right");
			driveTrain.drive(-speed,-1); //Turn left
			Timer.delay(2.0); // for 2 seconds	
			driveTrain.drive(-speed,0); //Move forward
		}
        }

    }
     
     private double getFrontDistance(){
     	// get distance based on front range finder
     	return frontRangeFinder.getVoltage() * 1000 / 0.98;
     }
     
     private double getBackDistance(){
     	// get distance based on back range finder
     	return backRangeFinder.getVoltage() * 1000 / 0.98;
     }
     
     private void exampleTwo(){
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
     
     private void exercise_3_0(){
     	// imagine a robot between two walls. this program stops the robot midway between 2 parallel walls
        double speed = 0;

        while (isEnabled() && isAutonomous()) {
        	if (getFrontDistance() > getBackDistance()){
        		speed = 0.1;
        	}
        	else if (getFrontDistance() < getBackDistance()){
        		speed = -0.1;
        	}
        	else{
        		speed = 0;
        	}
        	driveTrain.drive(speed, 0);
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
    
}
