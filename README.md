# RMI_Project
Client and Server program to demonstrate Java Remote Method Invocation (RMI)

Java Remote Method Invocation (RMI)
-----------------------------------
Code is compiled and tested in WINDOWS SUBSYSTEM FOR LINUX (UBUNTU).

Steps to compile and run code.
==============================
1) cd <project_folder>
2) javac *.java
3) open two terminals (one for SERVER and one for CLIENT)
4) In first terminal, execute server "java rmi_server"
5) In second terminal, execute client "java rmi_client <server_address> <server_port> <company_name>"

Example:
=======
1) cd <project_folder>
2) javac *.java
3) In first terminal  --> java rmi_server
4) In second terminal --> java rmi_client 127.0.1.1 5111 AMD

RMI
====
RMI(Remote Method Invocation) is a mechanism for communicating (only) between two machines running Java Virtual Machines.
