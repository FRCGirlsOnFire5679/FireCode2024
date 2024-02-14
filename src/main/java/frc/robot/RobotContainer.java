// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoBasic;
import frc.robot.commands.AutoShort;
import frc.robot.commands.AutoBlue3;
import frc.robot.commands.AutoBlue2;
import frc.robot.commands.AutoBlue1;
import frc.robot.commands.AutoNone;
import frc.robot.commands.TeleOp1;
import frc.robot.commands.TeleOp2;
import frc.robot.commands.AutoTEST;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Balence;
import frc.robot.subsystems.DriveMethods;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  // The robot's subsystems
  public final DriveTrain m_driveTrain = new DriveTrain();
  public final Balence m_Balence = new Balence();
  public final DriveMethods m_DriveMethods = new DriveMethods(m_driveTrain, m_Balence);
  // Joysticks
  private final XboxController joystick = new XboxController(0);

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  // A chooser for autonomous commands
  SendableChooser<Command> m_AutoChooser = new SendableChooser<>();
  //SendableChooser<Command> m_TeleChooser = new SendableChooser<>();
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_driveTrain);

    // SmartDashboard Buttons


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_driveTrain.setDefaultCommand(new TeleOp2(m_driveTrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_AutoChooser.setDefaultOption("AutoBasic", new AutoBasic(m_driveTrain, m_DriveMethods));
    m_AutoChooser.addOption("AutoShort", new AutoShort(m_driveTrain, m_DriveMethods));
    m_AutoChooser.addOption("AutoBlue1", new AutoBlue1(m_driveTrain, m_DriveMethods));
    m_AutoChooser.addOption("AutoBlue2", new AutoBlue2(m_driveTrain, m_DriveMethods));
    m_AutoChooser.addOption("AutoBlue3", new AutoBlue3(m_driveTrain, m_DriveMethods));
    m_AutoChooser.addOption("AutoTEST", new AutoTEST(m_driveTrain, m_DriveMethods));
    m_AutoChooser.addOption("AutoNone", new AutoNone(m_driveTrain, m_DriveMethods));
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Autonomous Command", m_AutoChooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    // Create some buttons

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public XboxController getJoystick() {
    return joystick;
  }

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_AutoChooser.getSelected();
  }

}
