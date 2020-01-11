/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.util.Xbox;
import frc.robot.commands.ButtonCommandEat;
import frc.robot.commands.ButtonCommandSpit;
import frc.robot.commands.ButtonCommandToggleClamp;

/**
 * The OI is where the two XBox controllers (or other controllers) are referenced, and some control is assigned.
 * Commands that run on buttons (not joysticks or triggers) will be linked here
 * Joystick control is defined in it's own command
 */
public class OI {

    // DO NOT CHANGE THESE! The manual subsystems depend on these controllers.
    public static Joystick DRIVER = new Joystick(0);
    public static Joystick OPERATOR = new Joystick(1);

    /**
     * If there are any commands linked to buttons, they are linked in this constructor.
     * I've linked ButtonCommandToggleClamp to B as an example
     */
    public OI() {
        Button toggleClamp = new JoystickButton(OPERATOR, Xbox.B); //clamp is toggled by pressing B on the operator controller
        toggleClamp.whenPressed(new ButtonCommandToggleClamp());
        Button manipulatorEat = new JoystickButton(OPERATOR, Xbox.A); // Manipulator sucks in
        manipulatorEat.whenPressed(new ButtonCommandEat());
        Button manipulatorSpit = new JoystickButton(OPERATOR, Xbox.Y); // Manipulator spits out
        manipulatorSpit.whenPressed(new ButtonCommandSpit());
    }
}
