# Handoff & Next Steps for Calico (IntelliJ IDEA)

Welcome back, Calico! Here is everything you need to know about the recent refactoring, test commands, and next steps for **CCsCanoes**.

---

## 🚀 Quick Start in IntelliJ IDEA

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

## 🛠️ Summary of Refactoring Changes

### 1. Hierarchy Refactor (`CanoeEntity extends AbstractBoat`)
- `CanoeEntity` now extends `net.minecraft.world.entity.vehicle.boat.AbstractBoat` directly instead of legacy `VehicleEntity`.
- **Vanilla Features Inherited**:
  - Full water physics & status mechanics (`IN_WATER`, `UNDER_WATER`, `ON_LAND`, `IN_AIR`).
  - Native multiplayer interpolation (`InterpolationHandler`).
  - Automatic paddle sound triggers via `getPaddleSound()`.
  - Underwater passenger ejection logic.
  - High-impact fall damage destruction dropping wood planks (3) + sticks (2) matching the canoe's wood type.

### 2. Solo 1-Seater Seating Math
- Canoes are configured as **single-seater vehicles** (`getMaxPassengers() == 1`).
- `getPassengerAttachmentPoint()` calculates dynamic rotational yaw vectors (`Math.sin(yaw) * zOffset`) so the player stays locked in the stern seat ($Z = -0.75$) without swinging out of the hull during tight turns.

### 3. Model & Renderer Alignment
- Model animations in `OakCanoe.java` and `SpruceCanoe.java` now consume `AbstractBoat`'s lerped rowing radians ($0 \dots \pi/8$) directly.
- `CanoeRenderer` uses fixed translation `poseStack.translate(0.0, 1.85, 0.0)` for rendering alignment.
- Unused legacy animation JSON files were cleaned up.

---

## 🎯 Recommended Next Steps & Ideas

- [ ] **Modded Wood Variants**: Add remaining wood types (Birch, Jungle, Acacia, Dark Oak, Mangrove, Cherry, Bamboo, Crimson, Warped) extending `CanoeEntity` or registering enum types.
- [ ] **Custom Paddles / Items**: Implement custom paddle items or crafting recipes.
- [ ] **Chest Canoes**: Explore `AbstractChestBoat` variant for storage canoes if desired.
