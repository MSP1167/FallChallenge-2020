/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ButtonCommandToggleClamp;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.util.Xbox;
/**
 * The clamp that the manipulator is mounted on.
 */
public class SubsystemClamp extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private  Solenoid CLAMP;

  public SubsystemClamp() {
    CLAMP = new Solenoid(Constants.CLAMP_SOLENOID_ID);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setOpen(boolean open) {
    if(CLAMP.get() == false){
      CLAMP.set(true);
    }
    else if(CLAMP.get() == true){
      CLAMP.set(false);
    }
    else{
      // WE GOT A PROBLEM
    }
  }

  public boolean getOpen() {
    return CLAMP.get();
  }
}
