//package org.firstinspires.ftc.teamcode.teleops;
//
//import static org.firstinspires.ftc.teamcode.robot.subsystems.HelixLocalisation.localizer;
//
//import com.acmerobotics.dashboard.FtcDashboard;
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.teamcode.commands.CommandsV1;
//
//import java.util.List;
//
//
//@TeleOp(name = "Main V1 Red")
//public class MainV1Red extends MainV0Red {
//
//    @Override
//    public void init() {
//        // tune inPerTick for ur drivetrain encoders
//        robot = new CommandsV1(hardwareMap, new Pose2d(0, 0, 0));
//        stateMachine = StateMachine.WAITING_FOR_START;
//    }
//
//    @Override
//    public void loop() {
//        // keep subsystems updated
//        robot.update();
//
//        /** Driver Operations **/
//        // drivetrain
//        bindCommonDriveTrain();
//        List<Double> driveValues = bindDriveTrain();
//
//        //binding
//        /**Above is only for testing**/
//        robot.fieldRelativeDrive(driveValues.get(1), driveValues.get(0), driveValues.get(2));
//
//        bindShooter();
//        //bindHood();
//
//
//        ElapsedTime timer = new ElapsedTime();
//
//
//        /** Below is hood bindings **/
//        //Disab le manual feeding as ball may get stuck
//        //And we will lose whole game
//        //operator actually can stop the shooting cycle now
//        if (gamepad1.x) {robot.startFeederBackwards();}
//        if (gamepad1.y) {robot.stopFeeder();}
//
////        if (gamepad1.dpad_up) {robot.shooter.rpmUp();}
////        if (gamepad1.dpad_down) {robot.shooter.rpmDown();}
////        if (gamepad1.dpad_left) {robot.hoodUp5();}
////        if (gamepad1.dpad_right) {robot.hoodDown5();}
//
//        double distance = robot.getDistanceFromGoal();
//
//        /**
//        if (!robot.getIsBlue()){
//            distance = distance+0.1;
//        }
//        **/
//
//        double hoodTarget = 0;
//        double rpmTarget = 0;
//
//        /**  Limelight Aiming Seperate Logic Functions
//        if(gamepad1.dpad_left &&  distance>0) { //This is for the close to tip shot
//            double dCalc = 2.25; //we will cap at the distance we use
//            if (distance < dCalc)
//                dCalc = distance;
//            hoodTarget = robot.calculateHoodAngle(dCalc);
//            rpmTarget = robot.calculateShooterRPM(dCalc);
//
//            robot.setHoodTarget(hoodTarget);
//            robot.shooter.rpmSet(rpmTarget);
//            robot.shooter.spinUpShooter();
//            robot.aimAtTag(robot.getCameraTagX());
//        }
//        robot.turnToTag(gamepad1.dpadLeftWasPressed());
//
//        if(gamepad1.dpad_right &&  distance>0) { //This is for the fence shot
//            double dCalc = 2.25; //we will cap at the distance we use
//            if (distance < dCalc)
//                dCalc = distance;
//            hoodTarget = robot.hood.calculateFencePositionToShoot(dCalc);
//            rpmTarget = robot.shooter.calculateFenceRpmToShoot(dCalc);
//
//            robot.setHoodTarget(hoodTarget);
//            robot.shooter.rpmSet(rpmTarget);
//            robot.shooter.spinUpShooter();
//            robot.aimAtTag(robot.getCameraTagX());
//        }
//        robot.turnToTag(gamepad1.dpadRightWasPressed());
//         **/
//
//        robot.turnToTag(gamepad1.dpadRightWasPressed()); // aims at april tag
//
//        if (gamepad1.dpad_up) {
//            robot.maxHood();
//        }
//
//        //if (gamepad1.dpad_down) {robot.stowHood();}
//        if (gamepad2.dpad_down) {robot.shooter.stopShooter();}
//        //if (gamepad2.dpad_left) {robot.stowHood();}
//
//        /** SHOOTING STUFF **/
//        //goal - close
//        if (gamepad2.left_trigger == 1.0){
//            robot.setHoodTarget(35);//40
//            robot.shooterversion1.updateShooterPID();
//            robot.shooter.rpmSet(1125); //currently the lowest shot that got out is at 1100 //may 30 is 1125 works but not for burst shot logic //1150 worked very well. just sometimes, it bounced off 12.5-12.6v
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//        }
//        /** Current Shooting Spot is Against Goal, slightly a bit to the left **/
//
//
//
//        //fence - mid
//        //This is preset shooting
//
//
//        if (gamepad2.aWasPressed()) {
//            robot.setHoodTarget(190);
//            robot.shooterversion1.updateShooterPID();// 40     //40
//            robot.shooter.rpmSet(1275); // 1525    //1150 worked very well. just sometimes, it bounced off 12.5-12.6v
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//            //robot.shooter.rpmSet(1265);
//        }
//
//
//            // This is limelight shooting
//        if (gamepad2.left_bumper){  //for high angle , we have 125 degree hood and 1333 rpm
//            if (!robot.getIsBlue()){
//                distance = distance-0.1;
//            }
//            double dCalc = 2.25; //we will cap at the distance we use
//            if (distance < dCalc)
//                dCalc = distance;
//            hoodTarget = robot.hood.calculateFencePositionToShoot(dCalc);
//            rpmTarget = robot.shooter.calculateFenceRpmToShoot(dCalc);
//
//            robot.setHoodTarget(hoodTarget);
//            robot.shooter.rpmSet(rpmTarget);
//            robot.shooterversion1.updateShooterPID();// 40     //40
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//        }
//        /** Current shooting spot is against the fence with the backwheel behind the middle line **/
//
//
//        //close to tip - further away
//
//        if (gamepad2.bWasPressed()) {
//            robot.turnToTag(true);
//            robot.setHoodTarget(195);//40 //180
//            robot.shooterversion1.updateShooterPID();
//            robot.shooter.rpmSet(1400); //1150 worked very well. just sometimes, it bounced off 12.5-12.6v
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//        }
//
//
//            // This is limelight shooting
//        if (gamepad2.right_bumper){
//            robot.turnToTag(true);
//            double dCalc = 2.25; //we will cap at the distance we use
//            if (distance < dCalc)
//                dCalc = distance;
//            hoodTarget = robot.hood.calculatePositionToShoot(dCalc);
//            rpmTarget = robot.shooter.calculateRpmToShoot(dCalc);
//            robot.setHoodTarget(hoodTarget);
//            robot.shooter.rpmSet(rpmTarget);
//            robot.shooterversion1.updateShooterPID();
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//        }
//        /** Current shooting spot is the corner in the large triangle but a bit forward **/
//
//        //very very far tip shooting
//        if (gamepad2.right_trigger == 1.0){
//            robot.turnToTagLongShooting(true);
//            robot.setHoodTarget(225);
//            robot.shooterversion1.updateVeryFarShooterPID();
//            robot.shooter.rpmSet(1700); //1610
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//        }
//
///** This is preset position shooting without regression
//        if (gamepad2.right_trigger == 1.0){
//            robot.turnToTagVariableFarShooting(true);
//            robot.setHoodTarget(225);
//            robot.shooterversion1.updateVeryFarShooterPID();
//            robot.shooter.rpmSet(1700); //1610
//            robot.shooter.setHold(false); //keep speed on t
//            robot.shooter.setBurstShotsRequested(3);
//            robot.launch(true);
//        }
//
// **/
//
//        //reset hood features
//        //if (gamepad2.dpad_down) {robot.hood.startResetHood();}
//        if (gamepad2.dpad_up) {robot.hood.stopResetHood();}
//
//        if (gamepad2.dpad_right) {
//            //robot.setHoodTarget(0);
//            robot.hood.startResetHood();
//            timer.reset();
//        }
//
//        if (gamepad2.dpad_left) {
//            robot.setHoodTarget(0);
//        }
//
//        if (timer.milliseconds() >= 1000) {
//            robot.hood.stopResetHood();
//        }
//
//
//        /**Testing for Driver Train**/
//        /**Disabled**/
//        /*
//        switch (stateMachine) {
//            case WAITING_FOR_START:
//                if (gamepad1.b){
//                    stateMachine = StateMachine.DRIVE_TO_TARGET_1;
//                }
//                break;
//
//            case DRIVE_TO_TARGET_1:
//                Pose2D pose2D = robot.drivetrain.getHelixLocalizer().getLocalizer().driver.getPosition();
//                if(robot.drivetrain.driveTo(pose2D, TARGET_1, 0.7, 0)){
//                    telemetry.addLine("At Position 1 - ZERO");
//                    stateMachine = StateMachine.AT_TARGET;
//                }
//                break;
//
//            case AT_TARGET:
//                telemetry.addData("Finish Position:", robot.getPodPose());
//                break;
//
//        }*/
//
//        /**End of testing**/
//
//        // telemetry
//        TelemetryPacket packet = new TelemetryPacket();
//        FtcDashboard dashboard = FtcDashboard.getInstance();
//
//        telemetryEssentials(telemetry, packet, distance);
//        //telemetryAlignment(telemetry, packet);
//        //telemetryEssentials(telemetry, packet, distance);
//        //extraTelemtry(telemetry);
//        /** End of Shooter Information **/
//        //telemetryShooting(telemetry, packet);
//        //telemetryHood(telemetry, packet, distance, hoodTarget, rpmTarget);
//        //telemetryLocalisation(telemetry, packet);
//
//
//        telementryRoadRunner(telemetry, packet);
//
//        /**Start of Drive Train Information **/
//        //telemetryDrivetrain(telemetry, packet);
//        /**End of Drive Train Information**/
//
//        telemetry.update();
//        dashboard.sendTelemetryPacket(packet);
//    }
//
//    protected void telemetryAlignment(Telemetry telemetry, TelemetryPacket packet){
//        telemetry.addData("Tag X", robot.getVision().getTagX());
//        packet.put("Tag X", robot.getVision().getTagX());
//    }
//    protected void telemetryEssentials(Telemetry telemetry, TelemetryPacket packet, double distance){
//        telemetry.addData("Shooter1 Vel", robot.getShooterVelocity());
//        packet.put("Shooter1 Vel", robot.getShooterVelocity());
//
//        telemetry.addData("Shooter1 Launch State", robot.getLaunchState());
//        packet.put("Shooter1 Launch State", robot.getLaunchState());
//
//        telemetry.addData("Shooter1 Burst Mode", robot.shooter.getBurstShotsRequests());
//        packet.put("Shooter1 Burst Mode", robot.shooter.getBurstShotsRequests());
//        telemetry.addData("Shooter1 Shots", robot.shooter.getBurstShotsFired());
//        packet.put("Shooter1 Shots", robot.shooter.getBurstShotsFired());
//
//
//        telemetry.addData("Shooter2 Fused - data source", robot.drivetrain.getHelixLocalizer().getFusedDateSource());
//        telemetry.addData("Shooter2 Distance to Goal - Fused", robot.getDistanceFromGoal());
//        packet.put("Shooter2 Fused - data source", robot.drivetrain.getHelixLocalizer().getFusedDateSource());
//        packet.put("Shooter2 Distance to Goal - Fused", robot.getDistanceFromGoal());
//
//        telemetry.addData("Shooter3 Robot Align to Goal", robot.getAlignStatus());
//        packet.put("Shooter3 Robot Align to Goal", robot.getAlignStatus());
//
//        telemetry.addData("Data to Goal - Vision", robot.getDistanceFromTag());
//        packet.put("Data to Goal - Vision", robot.getDistanceFromTag());
//    }
//
//    protected void telemetryLocalisation(Telemetry telemetry, TelemetryPacket packet){
//        //pose data for vision
//        telemetry.addData("Vision - pos", robot.getVisionPose());
//        telemetry.addData("Odo - pos", robot.getPodPose());
//        telemetry.addData("Fused - pos", robot.drivetrain.getHelixLocalizer().getFusedPos());
//        telemetry.addData("Fused - data source", robot.drivetrain.getHelixLocalizer().getFusedDateSource());
//        telemetry.addData("Last Visible Vision Pos", robot.drivetrain.getHelixLocalizer().getLastVisVisionPose2d());
//        telemetry.addData("Last Visible Odo Pos", robot.drivetrain.getHelixLocalizer().getLastVisOdoPose2d());
//        telemetry.addData("Data to Goal - Vision", robot.getDistanceFromTag());
//        telemetry.addData("Data to Goal - Fused", robot.getDistanceFromGoal());
//        packet.put("Vision - pos", robot.getVisionPose());
//        packet.put("Odo - pos", robot.getPodPose());
//        packet.put("Fused - pos", robot.drivetrain.getHelixLocalizer().getFusedPos());
//        packet.put("Fused - data source", robot.drivetrain.getHelixLocalizer().getFusedDateSource());
//        packet.put("Last Visible Vision Pos", robot.drivetrain.getHelixLocalizer().getLastVisVisionPose2d());
//        packet.put("Last Visible Odo Pos", robot.drivetrain.getHelixLocalizer().getLastVisOdoPose2d());
//        packet.put("Data to Goal - Vision", robot.getDistanceFromTag());
//        packet.put("Data to Goal - Fused", robot.getDistanceFromGoal());
//    }
//
//    @Override
//    protected void telemetryHood(Telemetry telemetry, TelemetryPacket packet, double distance, double hoodTarget, double rpmTarget){
//        telemetry.addData("Shooter Pwr", robot.getShooterPower());
//        packet.put("Shooter Pwr", robot.getShooterPower());
//        telemetry.addData("Hood Angle", robot.getHoodPosition());
//        packet.put("Hood Angle", robot.getHoodPosition());
//        telemetry.addData("Hood Power", robot.getHoodPower());
//        packet.put("Hood Power", robot.getHoodPower());
//        telemetry.addData("Hood Current", robot.getHoodCurrent());
//        packet.put("Hood Current", robot.getHoodCurrent());
//        telemetry.addData("Distance", distance);
//        packet.put("Distance",distance);
//        telemetry.addData("Hood Target", robot.getHoodTarget());
//        packet.put("Hood Target", robot.getHoodTarget());
//        telemetry.addData("Target Velocity", robot.shooter.getShooterVelTarget());
//        packet.put("Target Velocity", robot.shooter.getShooterVelTarget());
//        telemetry.addData("** Hood Target", hoodTarget);
//        telemetry.addData("** RPM Target", rpmTarget);
//    }
//    /**public void telementryRoadRunner(Telemetry telemetry, TelemetryPacket packet){
//        Pose2d pose = localizer.getPose();
//        telemetry.addData("Robot X", pose.position.x);
//        packet.put("Robot X", pose.position.x);
//
//        telemetry.addData("Robot Y", pose.position.y);
//        packet.put("Robot Y", pose.position.y);
//
//        telemetry.addData("heading", pose.heading);
//        packet.put("heading", pose.heading);
//    }
//     **/
//
//    public void telementryRoadRunner(Telemetry telemetry, TelemetryPacket packet) {
//        Pose2d pose = localizer.getPose();
//
//        telemetry.addData("Robot X", pose.position.x);
//        packet.put("Robot X", pose.position.x);
//
//        telemetry.addData("Robot Y", pose.position.y);
//        packet.put("Robot Y", pose.position.y);
//
//        double headingDegrees = Math.toDegrees(pose.heading.toDouble());
//
//        telemetry.addData("Heading", headingDegrees);
//        packet.put("Heading", headingDegrees);
//    }
//}
