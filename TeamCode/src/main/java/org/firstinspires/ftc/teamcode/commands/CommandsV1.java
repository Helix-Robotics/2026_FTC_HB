//package org.firstinspires.ftc.teamcode.commands;
//
//import androidx.annotation.NonNull;
//
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
//import com.acmerobotics.roadrunner.Action;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//
//
//public class CommandsV1 extends CommandAbstract {
//    public CommandsV1(HardwareMap hardwareMap, Pose2d initialPose) {
//        super(hardwareMap, initialPose);
//    }
//
//
//
//
//
///**
//
//
//    public double calculateHoodAngle(double distance) {
//        return hood.calculatePositionToShoot(distance);
//    }
//
//    @Override
//    public double calculateShooterRPM(double distance) {
//        return shooter.calculateRpmToShoot(distance);
//    }
//
//    public double calculateFenceHoodAngle(double distance)  {
//        return hood.calculateFencePositionToShoot(distance);
//    }
//
//    public double calculateFenceShooterRPM(double distance) {
//        return shooter.calculateFenceRpmToShoot(distance);
//    }
//
//
//
//
//
//
//    @Override
//    public void shoot() {
//        if (shooter.isReady() && hood.isReady()) {
//            feeder.feed();
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//    @Override
//    public double getDistanceFromGoal(){
//        return getDistanceFromGoalFused();
//    }
//
//    public class ShooterOdoStartAction implements Action {
//        // actions are formatted via telemetry packets as below
//        @Override
//        public boolean run(@NonNull TelemetryPacket packet) {
//            double distance = getDistanceFromGoal();
//            double hoodTarget = 0;
//            double rpmTarget = 0;
//
//            if(distance>0) {
//                double dCalc = 2.25; //we will cap at the distance we use
//                if (distance < dCalc)
//                    dCalc = distance;
//
//                hoodTarget = calculateHoodAngle(dCalc);
//                setHoodTarget(hoodTarget);
//
//                rpmTarget = calculateShooterRPM(dCalc);
//                shooter.rpmSet(rpmTarget);
//            }
//
//            if (hood.isBusy()){
//                return false;
//            }
//
//            return true;
//        }
//    }
//}
//
// **/
//
//}
