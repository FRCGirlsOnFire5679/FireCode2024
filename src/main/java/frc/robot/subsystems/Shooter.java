package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import edu.wpi.first.wpilibj.Timer;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.motorcontrol.Spark;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Shooter extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Spark leftShooter;
    private Spark rightShooter;
    private CANSparkMax rightMAXShooter;
    private CANSparkMax leftMAXShooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public Shooter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftShooter = new Spark(Constants.DriveConstants.kLeftShooterMotorPort);
        leftShooter.setInverted(false);

        rightShooter = new Spark(Constants.DriveConstants.kRightShooterMotorPort);
        rightShooter.setInverted(true);

        rightMAXShooter = new CANSparkMax(Constants.DriveConstants.kRightShooterMAXMotorPort, MotorType.kBrushless);
        rightMAXShooter.setIdleMode(IdleMode.kBrake);
        rightMAXShooter.setInverted(true);

        leftMAXShooter = new CANSparkMax(Constants.DriveConstants.kLeftShooterMAXMotorPort, MotorType.kBrushless);
        leftMAXShooter.setIdleMode(IdleMode.kBrake);
        leftMAXShooter.setInverted(false);

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

    public void intake(double speed) {
        setSparkMax(-speed);
        setSpark(-speed);
    }

    public void shoot(double speed) {
        setSparkMax(speed);
        setSpark(speed);
    }

    public void newShoot(double speed) {
        setSparkMax(speed);
        Timer timer = new Timer();
        timer.reset();
        timer.start();
        while (timer.get() < Constants.DriveConstants.kShooterMAXspinup) {
            setSparkMax(speed);
        }
        while ((Constants.DriveConstants.kShooterMAXspinup <= timer.get() )&& (timer.get() < 3)) {
            setSpark(speed);
        }
        setSpark(0);
        setSparkMax(0);
    }

    public void newIntake(double speed) {
        setSparkMax(-speed);
        Timer timer = new Timer();
        timer.reset();
        timer.start();
        while (timer.get() < 1) {
            setSparkMax(-speed);
            setSpark(-speed);
        }
        setSpark(0);
        setSparkMax(0);
    }

    public void hold(){
        setSparkMax(0);
        setSpark(0);
    }

    public void setSpark(double speed){
        leftShooter.set(speed);
        rightShooter.set(speed);
    }

    public void setSparkMax(double speed){
        leftMAXShooter.set(speed);
        rightMAXShooter.set(speed);
    }
}
