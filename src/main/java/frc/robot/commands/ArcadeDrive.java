package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDrive extends Command {
    private final DriveSubsystem drive;
    private final DoubleSupplier speed;
    private final DoubleSupplier turn;

    public ArcadeDrive(DriveSubsystem drive, DoubleSupplier speed, DoubleSupplier turn) {
        this.drive = drive;
        this.speed = speed;
        this.turn = turn;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.arcadeDrive(speed.getAsDouble(), turn.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drive.arcadeDrive(0, 0);
    }
}
