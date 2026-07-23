# Handoff & Next Steps for Calico (IntelliJ IDEA)

Welcome back, Calico! Here is everything you need to know about the next steps for **CCsCanoes**.

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

---

## Fine-Tuning Paddle Animations

If you want to adjust or customize the paddle's swinging speed, angles, or alignment, you can modify the values calculated in [CanoeRenderer.java]

* **Swinging Speed**:
  In `CanoeRenderer#extractRenderState`, change the multiplier in `float time = rowingTime * 1.5F;`. Increasing it makes the stroke cycle faster; decreasing it slows it down.
* **Pitch Range (Angle of Dip)**:
  Adjust `float basePitchOffset = Mth.clampedLerp((float) (-Math.PI / 12), (float) (Math.PI / 12), strokeProgress);`. Currently set to $\pm 15^\circ$ to prevent clipping into the front/back walls of the canoe model.
* **Yaw & Roll Alignment (Left / Right Turn angles)**:
  - `paddleYRot` controls the side-to-side diagonal angle.
  - `paddleZRot` controls the side-to-side tilt (roll).
  - You can modify the constants (e.g. `(float) (-Math.PI / 12)`) in the `isRowingLeft && isRowingRight` (Forward), `isRowingLeft` (Turn Left), and else (Turn Right) branches to tweak how far out the paddle is held while steering.

