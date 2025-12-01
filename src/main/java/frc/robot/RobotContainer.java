package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  private final DriveSubsystem drive = new DriveSubsystem();
  private final XboxController controller = new XboxController(0);

  public RobotContainer() {
    drive.setDefaultCommand(
      new RunCommand(
        () -> drive.tank(
          -controller.getLeftY(),
          -controller.getRightY() 
      ),
      drive
    )
  );
  
    new JoystickButton(controller, XboxController.Button.kA.value)
      .onTrue(new InstantCommand(() -> 
        drive.setDefaultCommand(
          new ArcadeDrive(
            drive,
            () -> -controller.getLeftY(),
            () ->  controller.getLeftX()
        )
      )
  ));

    new JoystickButton(controller, XboxController.Button.kB.value)
      .onTrue(new InstantCommand(() -> 
        drive.setDefaultCommand(
          new TankDrive(
            drive,
            () -> -controller.getLeftY(),
            () -> -controller.getRightY()
        )
      )
  ));
  }
}
