/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * The command that constantly drives the robot around.
 * 
 * NOTE: READ THE COMMENTS BRO I'M ONLY GIVING YOU COOL COMMENTS IN THIS COMMAND
 * AND THE SUBSYSTEMDRIVE CLASS AND YOURE ON YOUR OWN FOR THE REST OF THEM SO
 * READ MY COMMENTS
 */
public class ManualCommandDrive extends Command {
  public ManualCommandDrive() {
    /**
     * Any subsystems that the command will ever reference need to be declared here
     * using requires(). Since the only subsystem I use here is the drivetrain, that
     * is the only one I requre.
     * 
     * This one's free, you have to do requres() yourself for the rest of the
     * commands lol
     */

    requires(Robot.SUB_DRIVE);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    /**
     * Nothing needs to be done for the drivetrain when this command starts
     * (especially since it runs several times a second during teleop), so this
     * method can stay blank. This method will usually only be used for more complex
     * commands.
     */
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /**
     * After the command starts, this method is called periodically until the
     * isFinished() method returns true. Since this command exists simply to drive
     * the robot manually, what do y'all think you should put here?
     */
      Robot.SUB_DRIVE.DriveTankByController(OI.DRIVER);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /**
     * Again, this is one of those methods that isn't terribly important unless it is a complex command.
     * This method should return true when the command is done doing it's stuff, otherwise false.
     * We want the drivetrain to be constantly running. Therefore this command should be constantly running,
     * therefore the command should never finish. As a result, isFinished for this class should always return false.
     */

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    /**
     * It's like initalize() except its flipped. Again, used mainly for the more complex commands
     */
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    /**
     * Never used this one before, can't tell you exactly how it works.
     * (bruh moment)
     */
  }
}
