# Disk Scheduling
***
This project is a Java-based simulator designed to showcase how **Operating Systems** manage Disk I/O requests. The goal is to calculate the efficiency of various disk scheduling algorithms by tracking the physical movement of the disk's Read/Write head.

### Why Disk Scheduling?
Hard drives have a physical head that moves across cylinders to read data. To keep a system responsive, the OS must decide the most efficient order to visit these tracks. This simulator calculates the **Total Seek Operations** (the cumulative distance the head travels) for several key strategies.

### Supported Algorithms
***
I have implemented five of the most common scheduling strategies:

* **FCFS (First-Come, First-Served):** The simplest approach; requests are handled in the exact order they arrive.
* **STF (Shortest Track First):** Also known as SSTF; it picks the request closest to the current head position to minimize movement.
* **SCAN (Elevator Algorithm):** The head sweeps from one end of the disk to the other, servicing everything in its path before reversing.
* **C-SCAN (Circular SCAN):** Provides a more uniform wait time by servicing tracks in one direction, then jumping back to the start without servicing on the return trip.
* **C-LOOK:** An optimized version of C-SCAN that "looks" ahead; it reverses direction as soon as the last request is met, avoiding unnecessary travel to the disk edges.

### Performance Calculation
***
The primary metric for efficiency is the **Total Seek Operations (TSO)**. This is calculated by summing the absolute differences between the current track and the next track in the sequence:

$$TSO = \sum_{i=1}^{n} |Track_{i} - Track_{i-1}|$$

### Project Structure
The project follows a modular, package-based architecture:
* `Main.java`: The entry point containing the user menu and input handling.
* `Algorithms/`: A dedicated package housing the logic for each scheduling strategy.

### Installation & Setup
1. **Clone the Repository:**
```bash
git clone https://github.com/xKier2/Storage-Access-Algorithms.git
```

2. **Verify the File Existence:**
```bash
cd Storage-Access-Algorithms
ls
```

3. **Project Structure**
```text
├── src/
│   ├── Main.java                 
│   └── Algorithms/               
│       ├── FCFSDiskScheduling.java
│       ├── STFDiskScheduling.java
│       ├── SCANDiskScheduling.java
│       ├── CSCANDiskScheduling.java
│       └── CLOOKDiskScheduling.java
└── README.md
```

4. **Run the Program**
```bash
javac Main.java Algorithms/*.java
java Main
```

