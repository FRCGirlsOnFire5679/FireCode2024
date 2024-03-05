package frc.robot.commands;

//import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class TeleOp2 extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final DriveTrain m_driveTrain;
    private final Shooter m_shooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    private XboxController driveController = new XboxController(0);
    private XboxController operatorController = new XboxController(1);
    //private XboxController maniplatorController = new XboxController(1);
    private Trigger sprintButton = new JoystickButton(driveController, XboxController.Button.kRightStick.value);
    

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    boolean hardStop = false;


    public TeleOp2(DriveTrain driveTrainSubsystem, Shooter shooterSubSystem) {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_driveTrain = driveTrainSubsystem;
        m_shooter = shooterSubSystem;
        addRequirements(m_driveTrain);
        addRequirements(m_shooter);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        hardStop = false;
        SmartDashboard.putBoolean("Hard Stop", hardStop);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double leftSpeedFactor = Constants.DriveConstants.kLeftSpeedFactor;
        double rightSpeedFactor = Constants.DriveConstants.kRightSpeedFactor;
        if(checkSprint()){
            m_driveTrain.sprint(leftSpeedFactor * driveController.getRawAxis(1), rightSpeedFactor * driveController.getRawAxis(5));
        } else if (checkCrawl()){
             m_driveTrain.crawl(leftSpeedFactor * driveController.getRawAxis(1), rightSpeedFactor * driveController.getRawAxis(5), driveController.getRawAxis(3));
        } else {
             m_driveTrain.drive(leftSpeedFactor * driveController.getRawAxis(1), rightSpeedFactor * driveController.getRawAxis(5));
        }
        
     
        if (driveController.getRawButtonPressed(1)) {
            //Decide button value
            if (hardStop) {
                m_driveTrain.setCoast();
                hardStop = false;
                SmartDashboard.putBoolean("Hard Stop", hardStop);
            } else {
                m_driveTrain.setBrake();
                hardStop = true;
                SmartDashboard.putBoolean("Hard Stop", hardStop);
            }
        }
        
        if(checkShoot()){
            m_shooter.shoot(1);
        }
        else if (checkIntake()) {
            m_shooter.intake(1);
        } else {
            m_shooter.shoot(0);
        }
    }

    public boolean checkShoot(){
        if ((operatorController.getRawButton(3)) && (!operatorController.getRawButton(1))){
            return true;
        }
        return false;
    }

    public boolean checkIntake(){
        if ((operatorController.getRawButton(1)) && (!operatorController.getRawButton(3))){
            return true;
        }
        return false;
    }

    public boolean checkSprint() {
        if(sprintButton.getAsBoolean() == true && driveController.getRawAxis(3) <= 0.2){
           return true;
        } 
        return false;

    }

     public boolean checkCrawl() {
        if(sprintButton.getAsBoolean() == false && driveController.getRawAxis(3) > 0.2){
           return true;
        } 
        return false;
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveTrain.drive(0.0, 0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
} 
