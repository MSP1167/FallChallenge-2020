/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ManualCommandDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.util.Xbox;

/**
 * The Subsystem class for the drivetrain. All methods and objects required for driving the robot should be put 
 * here (so motor controllers and stuff). DriveTankByJoystick() will be called periodically by ManualCommandDrive
 * while the robot is ENABLED.
 */
public class SubsystemDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Declare Talon Names
  private TalonSRX RIGHT_MASTER;
  private TalonSRX LEFT_MASTER;
  private TalonSRX RIGHT_SLAVE;
  private TalonSRX LEFT_SLAVE;

  // Declare Talon Values
  public SubsystemDrive() {
    RIGHT_MASTER = new TalonSRX(Constants.DRIVE_RIGHT_MASTER_ID);
    LEFT_MASTER = new TalonSRX(Constants.DRIVE_LEFT_MASTER_ID);
    RIGHT_SLAVE = new TalonSRX(Constants.DRIVE_RIGHT_SLAVE_ID);
    LEFT_SLAVE = new TalonSRX(Constants.DRIVE_LEFT_SLAVE_ID);
  }

  @Override
  public void initDefaultCommand() {
    /**
     * Small note: for subsystems that should be running at all times during teleop (such as the drivetrain), 
     * you will need to set a "default command" that is called  while the robot is running. This command is 
     * defined and paired to this substem below with the setDefaultCommand() method. So in order for ManualCommandDrive 
     * to run, it has to be paired to this subsystem below, otherwise the robot will never respond to controller input.
     * 
     * This ones for free broskis, y'all have to do the rest
     */

    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualCommandDrive());
  }

  /**
   * Drives the robot based on controller input
   * Right trigger is forward, left trigger is backward, left joystick steers.
   * @param controller the XBox controller to pull input from (OI.DRIVER or OI.OPERATOR)
   */
  public void DriveTankByController(Joystick controller) {
    // Basic Var Names
    double RIGHT_SPEED;
    double LEFT_SPEED;
    double STEERING;
    double THROTTLE;
    double extra;
    
    // Set those variables
    THROTTLE = Xbox.RT(controller) - Xbox.LT(controller);
    STEERING = Xbox.LEFT_X(controller);
    RIGHT_SPEED = THROTTLE - STEERING;
    LEFT_SPEED = THROTTLE + STEERING;

    // Fancy way of preventing overflow (-1 Min & 1 Max)
    if(RIGHT_SPEED > 1){
      extra = 1 - RIGHT_SPEED;
      RIGHT_SPEED = RIGHT_SPEED - extra;
    }
    if(LEFT_SPEED > 1){
      extra = 1 - LEFT_SPEED;
      LEFT_SPEED = LEFT_SPEED - extra;
    }
    if(RIGHT_SPEED < -1){
      extra = -1 - RIGHT_SPEED;
      RIGHT_SPEED = RIGHT_SPEED + extra;
    }
    if(LEFT_SPEED < -1){
      extra = -1 - LEFT_SPEED;
      LEFT_SPEED = LEFT_SPEED + extra;
    }

    // Finally set the value of the talons
    RIGHT_MASTER.set(ControlMode.PercentOutput, RIGHT_SPEED);
    RIGHT_SLAVE.set(ControlMode.PercentOutput, RIGHT_SPEED);
    LEFT_MASTER.set(ControlMode.PercentOutput, LEFT_SPEED);
    LEFT_SLAVE.set(ControlMode.PercentOutput, LEFT_SPEED);
  }
}
