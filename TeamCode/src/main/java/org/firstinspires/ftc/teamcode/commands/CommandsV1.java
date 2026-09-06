package org.firstinspires.ftc.teamcode.commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.subsystems.Feeder;
import org.firstinspires.ftc.teamcode.robot.subsystems.Hood;
import org.firstinspires.ftc.teamcode.robot.subsystems.ShooterV1;

public class CommandsV1 extends CommandAbstract {
    public CommandsV1(HardwareMap hardwareMap, Pose2d initialPose) {
        super(hardwareMap, initialPose);
    }

    @Override
    public void createShooterInstances() {
        feeder = new Feeder(hardwareMap);
        shooterversion1 = new ShooterV1(hardwareMap, feeder, hood);
        shooter = shooterversion1;
        hood = new Hood(hardwareMap);
    }

    @Override
    public void updateShooter() {
        feeder.update();
        shooter.update();
        hood.hoodCheck();
    }

    @Override
    public void setHoodPIDF() {
        hood.setHoodPIDF();
    }

    @Override
    public double getHoodTarget() {
        return hood.getHoodTarget();
    }

    @Override
    public double getHoodCurrent() {
        return hood.getHoodCurrent();
    }

    public void forceFeed() {
        feeder.start();
    }

    public void stopFeed() {
        feeder.stop();
    }

    @Override

    public void hoodUp5() {
        hood.hoodUpIncrement(5);
    }

    @Override

    public void hoodDown5() {
        hood.hoodDownIncrement(5);
    }

    public double calculateHoodAngle(double distance) {
        return hood.calculatePositionToShoot(distance);
    }

    @Override
    public double calculateShooterRPM(double distance) {
        return shooter.calculateRpmToShoot(distance);
    }

    public double calculateFenceHoodAngle(double distance)  {
        return hood.calculateFencePositionToShoot(distance);
    }

    public double calculateFenceShooterRPM(double distance) {
        return shooter.calculateFenceRpmToShoot(distance);
    }

    @Override
    public void aimAndPrepare() {
        if (!isAiming) {
            shooter.spinUpShooter();
            double dist = vision.getDistanceToTagOnField();
            if (dist != -1) {
                double degrees = hood.calculatePositionToShoot(dist);
                hood.setTargetPosition(degrees);
            }
            isAiming = true;  // prevent repeated calls
        }
    }

    @Override
    public void cancelAiming() {
        isAiming = false;
    }

    @Override
    public void shoot() {
        if (shooter.isReady() && hood.isReady()) {
            feeder.feed();
        }
    }

    @Override
    public void stowHood() {
        hood.stowHood();
    }

    @Override
    public void maxHood() {
        hood.maxHood();
    }

    @Override
    public void zeroHood() {
        hood.stowHood();
    }

    @Override
    public void hoodUp() {
        hood.maxHood();
    }

    @Override
    public double getHoodPower() {
        return hood.getHoodPower();
    }

    @Override
    public double getHoodPosition() {
        return hood.getHoodAngleDegrees();
    }
//    @Override
//    public double getDistanceFromTag() { return HelixLocalisation.getDistanceFromGoal(false); }

    @Override
    public Action setHoodTarget(double angle) {
        hood.setTargetPosition(angle);
        return null;
    }

    @Override
    public double getDistanceFromGoal(){
        return getDistanceFromGoalFused();
    }

    public class ShooterOdoStartAction implements Action {
        // actions are formatted via telemetry packets as below
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            double distance = getDistanceFromGoal();
            double hoodTarget = 0;
            double rpmTarget = 0;

            if(distance>0) {
                double dCalc = 2.25; //we will cap at the distance we use
                if (distance < dCalc)
                    dCalc = distance;

                hoodTarget = calculateHoodAngle(dCalc);
                setHoodTarget(hoodTarget);

                rpmTarget = calculateShooterRPM(dCalc);
                shooter.rpmSet(rpmTarget);
            }

            if (hood.isBusy()){
                return false;
            }

            return true;
        }
    }
}
