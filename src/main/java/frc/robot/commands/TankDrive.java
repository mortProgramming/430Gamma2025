package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TankDrive extends Command {
    private final DriveSubsystem drive;
    private final DoubleSupplier left;
    private final DoubleSupplier right;

    public TankDrive(DriveSubsystem drive, DoubleSupplier left, DoubleSupplier right) {
        this.drive = drive;
        this.left = left;
        this.right = right;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.tank(left.getAsDouble(), right.getAsDouble());
    }

    
    @Override
    public void end(boolean interrupted) {
        drive.tank(0, 0);
    }
}
