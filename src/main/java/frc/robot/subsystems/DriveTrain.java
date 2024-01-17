// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;






// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private CANSparkMax frontLeftController;
    private CANSparkMax rearLeftController;
    private CANSparkMax frontRightController;
    private CANSparkMax rearRightController;
    private DifferentialDrive robotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        frontLeftController = new CANSparkMax(Constants.DriveConstants.kLeftMotorFrontPort, MotorType.kBrushless);
        frontLeftController.setInverted(true);

        rearLeftController = new CANSparkMax(Constants.DriveConstants.kLeftMotorBackPort, MotorType.kBrushless);
        rearLeftController.setInverted(true);

        frontRightController = new CANSparkMax(Constants.DriveConstants.kRightMotorFrontPort, MotorType.kBrushless);
        frontRightController.setInverted(false);

        rearRightController = new CANSparkMax(Constants.DriveConstants.kRightMotorBackPort, MotorType.kBrushless);
        rearRightController.setInverted(false);

        frontLeftController.follow(rearLeftController);
        frontRightController.follow(rearRightController);

        robotDrive = new DifferentialDrive(rearLeftController, rearRightController);
        addChild("Robot Drive", robotDrive);
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setMaxOutput(1.0);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void drive(double left, double right) {
        robotDrive.tankDrive(left, right);
    }

    public void sprint(double left, double right){
       robotDrive.tankDrive(left * Constants.DriveConstants.kSprintLeftSpeedFactor, right * Constants.DriveConstants.kSprintRightSpeedFactor);
    }
}
