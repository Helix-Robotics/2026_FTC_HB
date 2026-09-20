package org.firstinspires.ftc.teamcode.robot.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Intake {
    private DcMotorEx intake;

    public Intake(HardwareMap hw) {
        intake = hw.get(DcMotorEx.class, "intake");
    }

    public void setintake(double power) {
        intake.setPower(power);
    }
}
