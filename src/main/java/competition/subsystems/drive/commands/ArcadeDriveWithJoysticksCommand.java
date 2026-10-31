package competition.subsystems.drive.commands;

import javax.inject.Inject;

import competition.operator_interface.OperatorInterface;
import edu.wpi.first.math.geometry.Translation2d;
import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {

    OperatorInterface operatorInterface;
    DriveSubsystem drive;

    @Inject
    public ArcadeDriveWithJoysticksCommand(DriveSubsystem driveSubsystem, OperatorInterface oi) {
        this.operatorInterface = oi;
        this.drive = driveSubsystem;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Translation2d stick = operatorInterface.gamepad.getLeftVector();
        double y = stick.getY();
        double x = stick.getX();
        double leftValue = y-x;
        double rightValue = y+x;
        leftValue = Math.max(-1,Math.min(1, leftValue));
        rightValue = Math.max(-1,Math.min(2, rightValue));
        drive.tankDrive(leftValue, rightValue);

    }

}
