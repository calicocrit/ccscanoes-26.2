# Handoff & Next Steps for Calico (IntelliJ IDEA)

Welcome back, Calico! Here is everything you need to know about the recent refactoring, test commands, and next steps for **CCsCanoes**.

---

## Quick Start in IntelliJ IDEA

1. **Open Project**: Open this workspace root directory in IntelliJ IDEA.
2. **Gradle Import**: Allow IntelliJ to auto-import the Gradle project (`build.gradle`).
3. **Run Client Task**:
   - Open the **Gradle Tool Window** on the right sidebar.
   - Navigate to `Tasks` ➔ `neoforge` ➔ `runClient` (or `runclient`).
   - Double-click to launch the Minecraft NeoForge test client.
   - *CLI alternative in IntelliJ Terminal*:
     ```bash
     ./gradlew runClient
     ```
