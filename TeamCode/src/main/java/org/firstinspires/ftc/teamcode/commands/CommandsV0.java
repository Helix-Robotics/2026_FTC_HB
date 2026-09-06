package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.subsystems.Feeder;
import org.firstinspires.ftc.teamcode.robot.subsystems.ShooterV0;

public class CommandsV0 extends CommandAbstract{
    public CommandsV0(HardwareMap hardwareMap, Pose2d initialPose) {
        super(hardwareMap,initialPose);
    }

    @Override
    public void createShooterInstances(){
        feeder = new Feeder(hardwareMap);
        shooter = new ShooterV0(hardwareMap, feeder, hood);
    }

    @Override
    public void updateShooter(){
        feeder.update();
        shooter.update();
    }

    @Override
    public void aimAndPrepare() {
        //Do nothing for v0
    }

    @Override
    public void cancelAiming() {
        isAiming = false;
    }

    @Override
    public void shoot() {
        if (shooter.isReady()) {
            feeder.feed();
        }
    }

    @Override
    public void stowHood() {
        //We dont have hood, we do nothing
    }

    @Override
    public void maxHood() {
        //We dont have hood, we do nothing
    }

    @Override
    public void zeroHood() {
        //We dont have hood, we do nothing
    }

    @Override
    public void hoodUp() {
        //We dont have hood, we do nothing
    }
    @Override
    public void hoodUp5() {

    }

    @Override
    public void hoodDown5() {

    }

    @Override
    public double calculateHoodAngle(double distance) {
        return 0.0;
    }

    @Override
    public double calculateShooterRPM(double distance) {
        return 0.0;
    }

    @Override
    public Action setHoodTarget(double angle) {

        return null;
    }

    @Override
    public double getHoodPower() { return 0.0; }
    @Override
    public double getHoodPosition() { return 0.0; }

    @Override
    public double getHoodTarget() {return 0.0;}

    @Override
    public double getHoodCurrent() {return 0.0;}
}
