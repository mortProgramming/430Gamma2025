package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private final SparkMax leftMaster;
    private final SparkMax leftFollower;
    private final SparkMax rightMaster;
    private final SparkMax rightFollower;

    private final DifferentialDrive drive;

    public DriveSubsystem() {
        //normally intialize in constants
        leftMaster = new SparkMax(1, MotorType.kBrushless);
        leftFollower = new SparkMax(4, MotorType.kBrushless);

        rightMaster = new SparkMax(2, MotorType.kBrushless);
        rightFollower = new SparkMax(3, MotorType.kBrushless);

        SparkMaxConfig leftMasterConfig = new SparkMaxConfig();
        SparkMaxConfig rightMasterConfig = new SparkMaxConfig();

        leftMasterConfig
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40);

        rightMasterConfig
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40);
        
        //configs
        SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
        SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

        leftFollowerConfig.follow(leftMaster, false);
        rightFollowerConfig.follow(rightMaster, false);

        leftMaster.configure(leftMasterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightMaster.configure(rightMasterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        leftFollower.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFollower.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        // rightMaster.setInverted(true);

        drive = new DifferentialDrive(leftMaster, rightMaster);

        drive.setSafetyEnabled(false);
    }

    public void tank(double left, double right) {
        drive.tankDrive(left, right, true);
    }
    
    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation, true);
    }
}
