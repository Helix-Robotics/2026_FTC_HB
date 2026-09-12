//
//
//
//package org.firstinspires.ftc.teamcode.autos;
//
//import androidx.annotation.NonNull;
//import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
//import com.acmerobotics.roadrunner.Action;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.PoseVelocity2d;
//import com.acmerobotics.roadrunner.SequentialAction;
//import com.acmerobotics.roadrunner.SleepAction;
//
//import com.acmerobotics.roadrunner.ParallelAction;
//import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.acmerobotics.roadrunner.ftc.Actions;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//import org.firstinspires.ftc.teamcode.commands.CommandAbstract;
//import org.firstinspires.ftc.teamcode.commands.CommandsV1;
//import org.firstinspires.ftc.teamcode.robot.subsystems.MecanumDrive;
//import org.firstinspires.ftc.teamcode.utils.Localizer;
//
//@Config
//@Autonomous(name = "Test Auto", group = "Autonomous")
//public class TestAuto extends LinearOpMode {
//    protected CommandAbstract robot;
//
//    @Override
//    public void runOpMode() {
//        Pose2d initialPose = new Pose2d(0.0, 0.0, 0.0);
//
//        robot = new CommandsV1(hardwareMap, initialPose);
//        robot.setIsBlue(false);
//
//        MecanumDrive md = robot.drivetrain;
//        Localizer localizer = md.getLocalizer();
//
//
//        /**
//         TrajectoryActionBuilder tab1 = md.actionBuilder(initialPose)
//         .strafeToLinearHeading(new Vector2d(3.0, 0.0), Math.toRadians(-18.0));
//
//         TrajectoryActionBuilder tab2 = tab1.endTrajectory().fresh()
//         .strafeToLinearHeading(new Vector2d(3.0, -35.0), Math.toRadians(-18.0))
//         .strafeToLinearHeading(new Vector2d(3.0, 0.0), Math.toRadians(-18.0));
//
//
//         //.strafeToConstantHeading(new Vector2d(3.0, -35.0))
//         //.strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//
//         TrajectoryActionBuilder tab3 = tab2.endTrajectory().fresh()
//         .strafeToLinearHeading(new Vector2d(3.0, -35.0), Math.toRadians(-18.0))
//         .strafeToLinearHeading(new Vector2d(3.0, 0.0), Math.toRadians(-18.0));
//
//
//         //.strafeToConstantHeading(new Vector2d(3.0, -35.0))
//         //.strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//
//         TrajectoryActionBuilder tab4 = tab3.endTrajectory().fresh()
//         .strafeToLinearHeading(new Vector2d(53.0, -37.0), Math.toRadians(-80.0))
//         .waitSeconds(0.3)
//         .strafeToLinearHeading(new Vector2d(53.0, -34.0), Math.toRadians(-18.0))
//
//
//         .strafeToLinearHeading(new Vector2d(7.5, -34.0), Math.toRadians(-18.0))
//         //.strafeToConstantHeading(new Vector2d(7.5, -34.0))
//
//
//         .strafeToLinearHeading(new Vector2d(3.0, 0.0), Math.toRadians(-18.0));
//
//         TrajectoryActionBuilder tab5 = tab4.endTrajectory().fresh()
//         .strafeToLinearHeading(new Vector2d(3.0, -35.0), Math.toRadians(-18.0))
//         .strafeToLinearHeading(new Vector2d(3.0, 0.0),Math.toRadians(-18.0));
//
//         //.strafeToConstantHeading(new Vector2d(3.0, -35.0))
//         //.strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//         TrajectoryActionBuilder tab6 = tab5.endTrajectory().fresh()
//         .strafeToLinearHeading(new Vector2d(3.0, -35.0), Math.toRadians(-18.0))
//         .strafeToLinearHeading(new Vector2d(3.0, 0.0),Math.toRadians(-18.0));
//
//         //.strafeToConstantHeading(new Vector2d(3.0, -35.0))
//         //.strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//
//         // Testing
//         TrajectoryActionBuilder tab7 = md.actionBuilder(initialPose)
//         .strafeToLinearHeading(new Vector2d(25.0, 0.0), Math.toRadians(0.0))
//         .waitSeconds(1)
//         .strafeToConstantHeading(new Vector2d(50.0, 0.0));
//         //.lineToConstantHeading(new Vector2d(25.0, 0.0));
//         **/
//
//
//
//        TrajectoryActionBuilder tab1 = md.actionBuilder(initialPose)
//                .strafeToLinearHeading(new Vector2d(3.0, 0.0), Math.toRadians(-18.0));
//
//        TrajectoryActionBuilder tab2 = tab1.endTrajectory().fresh()
//                .strafeToConstantHeading(new Vector2d(3.0, -35.0))
//                .strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//
//
//
//
//        TrajectoryActionBuilder tab3 = tab2.endTrajectory().fresh()
//                .strafeToConstantHeading(new Vector2d(3.0, -35.0))
//                .strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//
//
//
//
//
//        TrajectoryActionBuilder tab4 = tab3.endTrajectory().fresh()
//                .strafeToLinearHeading(new Vector2d(53.0, -37.0), Math.toRadians(-80.0))
//                .waitSeconds(0.3)
//                .strafeToLinearHeading(new Vector2d(53.0, -34.0), Math.toRadians(-18.0))
//
//
//                .strafeToConstantHeading(new Vector2d(7.5, -34.0))
//
//
//                .strafeToLinearHeading(new Vector2d(3.0, 0.0), Math.toRadians(-18.0));
//
//        TrajectoryActionBuilder tab5 = tab4.endTrajectory().fresh()
//                .strafeToConstantHeading(new Vector2d(3.0, -35.0))
//                .strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//        TrajectoryActionBuilder tab6 = tab5.endTrajectory().fresh()
//                .strafeToConstantHeading(new Vector2d(3.0, -35.0))
//                .strafeToConstantHeading(new Vector2d(3.0, 0.0));
//
//
//        // Testing
//        TrajectoryActionBuilder tab7 = md.actionBuilder(initialPose)
//                .strafeToLinearHeading(new Vector2d(25.0, 0.0), Math.toRadians(0.0))
//                .waitSeconds(1)
//                .strafeToConstantHeading(new Vector2d(50.0, 0.0));
//        //.lineToConstantHeading(new Vector2d(25.0, 0.0));
//
//
//
//
//
//
//
//        while (!isStopRequested() && !opModeIsActive()) {
//            localizer.update();
//            Pose2d position = localizer.getPose();
//
//            telemetry.addData("X", position.position.x);
//            telemetry.addData("Y", position.position.y);
//            telemetry.addData("deg", Math.toDegrees(position.heading.toDouble()));
//            telemetry.update();
//        }
//
//        waitForStart();
//
//        if (isStopRequested()) return;
//
//        Action trajectoryActionChosen = tab1.build();
//
//        Action trajectoryActionChosen2 = tab2.build();
//
//        Action trajectoryActionChosen3 = tab3.build();
//
//        Action trajectoryActionChosen4 = tab4.build();
//
//        Action trajectoryActionChosen5 = tab5.build();
//
//        Action trajectoryActionChosen6 = tab6.build();
//
//        Action trajectoryActionChosen7 = tab7.build();
//
//        runActionSafely(
//
//
//                new SequentialAction(
//                        new ParallelAction(
//                                //robot.hood.hoodFarAction(),
//                                //robot.shooter.spinUpShooterAction(1675),
//                                trajectoryActionChosen
//                        ),
//
//
//
//                        new ParallelAction(
//                                robot.turnToTagLongShootingActions()
//                                //robot.shooter.farLaunch()
//                        ),
//
//
//
//
//                        trajectoryActionChosen2,
//                        new ParallelAction(
//                                robot.turnToTagLongShootingActions()
//                                //robot.shooter.farLaunch()
//                        ),
//                        trajectoryActionChosen3,
//                        new ParallelAction(
//                                robot.turnToTagLongShootingActions()
//                                //robot.shooter.farLaunch()
//                        ),
//                        trajectoryActionChosen4,
//                        new ParallelAction(
//                                robot.turnToTagLongShootingActions()
//                                //robot.shooter.farLaunch()
//                        ),
//                        trajectoryActionChosen5,
//                        new ParallelAction(
//                                robot.turnToTagLongShootingActions()
//                                //robot.shooter.farLaunch()
//                        ),
//                        trajectoryActionChosen6,
//                        new ParallelAction(
//                                robot.turnToTagLongShootingActions()
//                                //robot.shooter.farLaunch()
//                        )
//                ), 30.0);
//
//
//
//    }
//
//    private void runActionSafely(Action action, double timeoutSeconds) {
//        ElapsedTime timer = new ElapsedTime();
//        TelemetryPacket packet = new TelemetryPacket();
//
//        timer.reset();
//
//        while (opModeIsActive() && timer.seconds() < timeoutSeconds) {
//            boolean stillRunning = action.run(packet);
//
//            if (!stillRunning) {
//                break;
//            }
//
//            telemetry.addData("RoadRunner", "Running");
//            telemetry.addData("Time", timer.seconds());
//            telemetry.update();
//
//            idle();
//        }
//
//        // Final safety stop
//        robot.drivetrain.setDrivePowers(
//                new PoseVelocity2d(
//                        new Vector2d(0, 0),
//                        0
//                )
//        );
//
//    }
//
//}
