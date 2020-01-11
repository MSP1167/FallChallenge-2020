/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Toggles the state of SubsystemClamp.
 * 
 * Note on InstantCommands:
 * Instant commands are meant to do one small task and then exit.
 * For instant commands, initialize() is the same as execute() for a normal command,
 * but you do not have to worry about isFinished(), or interrupted(), or any of the
 * weird methods. Again, this is for really simple tasks.
 */
public class ButtonCommandToggleClamp extends InstantCommand {

  public ButtonCommandToggleClamp() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.SUB_CLAMP);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.SUB_CLAMP.setOpen(true);
  }

}
