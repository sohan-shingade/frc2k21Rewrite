// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

/**
 * HopperAutomatic runs the motors until 
 */
public class HopperAutomatic extends CommandBase {
  private Hopper hopper;

  /** Creates a new HopperAutomatic. */
  public HopperAutomatic(Hopper hopper) {
    this.hopper = hopper;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hopper);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hopper.runTillFull();
    hopper.setState(Hopper.State.RUNNING);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hopper.setState(Hopper.State.DISABLED);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return hopper.topIsFull() && hopper.botIsFull();
  }
}
