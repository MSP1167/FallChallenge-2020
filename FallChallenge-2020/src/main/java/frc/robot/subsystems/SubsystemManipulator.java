/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ButtonCommandEat;
import frc.robot.commands.ButtonCommandSpit;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.util.Xbox;

/**
 * The manipulator, which consists of two motors that spin opposite of each other.
 */
public class SubsystemManipulator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX RIGHT_MANIP;
  private TalonSRX LEFT_MANIP;

  public SubsystemManipulator() {
    RIGHT_MANIP = new TalonSRX(Constants.MANIPULATOR_RIGHT_MOTOR_ID);
    LEFT_MANIP = new TalonSRX(Constants.MANIPULATOR_LEFT_MOTOR_ID);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**
   * Sucks the cubes in. This should happen when A is pressed.
   */
  public void eat() {
    RIGHT_MANIP.set(ControlMode.PercentOutput, -1);
    LEFT_MANIP.set(ControlMode.PercentOutput, 1);
  }

  /**
   * Pushes the cubes out. This should happen when Y is pressed.
   */
  public void spit() {
    RIGHT_MANIP.set(ControlMode.PercentOutput, 1);
    LEFT_MANIP.set(ControlMode.PercentOutput, -1);
  }

  public void stop(){
    RIGHT_MANIP.set(ControlMode.PercentOutput, 0);
    LEFT_MANIP.set(ControlMode.PercentOutput, 0);
  }
}
