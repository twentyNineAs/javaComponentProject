# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.11.07

### Added

- Implemented secondary methods in LogicGatesSecondary.java.
- Added new method in LogicGates.java to allow the change of inputs, and not just Operators.
- Added LogicGates1.java file to call constructor in LogicGatesSecondary.java. As of the current moment, it contains no proper implementations.

### Updated

- Changed design to implement enum operators.
- Changed design to make inputs for disassembling and assembling to LogicGates components. This is to better mimic binary tree behavior.
- Moved height method out of secondary and into kernel.

## 2025.10.18

### Added

- Designed kernel and enhanced interfaces for LogicGates component

### Updated

- Changed design to better model complex logic gate sequences through binary tree structures.

## 2025.10.17

### Added

- Designed a proof of concept for the LogicGates component

## 2025.10.17

### Added

- Designed a logicGates component
- Designed a timerClock component
- Designed a baseConverter component