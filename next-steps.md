# Next Steps for ze Canoe Entity

Two paths to get the canoe rendering in-game.

---

## Plan A: Extend `AbstractBoat` (vanilla physics)

**you Miss Calico does this:**

- Rename/restructure the bone hierarchy to match what `AbstractBoatModel` expects:

   ```
   root/
   ├── bottom       - canoe hull body
   ├── back         - rear wall
   ├── front        - front wall
   ├── left         - left side
   ├── right        - right side
   ├── left_paddle  - left paddle (gets animated automatically)
   └── right_paddle - right paddle (gets animated automatically)
   ```

- the paddles **must** be named `left_paddle` and `right_paddle` — `AbstractBoatModel.setupAnim()` finds these by name and animates them based on `BoatRenderState.rowingTimeLeft`/`rowingTimeRight`.
- UV layout can be whatever works - you're not tied to the vanilla texture template.
- re-export the geometry JSON and the Java model class.
- delete the old `OakCanoe.java` / `SpruceCanoe.java` and replace with the new export (technically i can do this).

**me do :**
- just wiring things up, 50-100 lines of code total

---

## Plan B: Standalone entity (custom everything)

**Modeler:** Nothing changes. The existing `OakCanoe` / `SpruceCanoe` models with `bone2` / `bone` work as-is.

**Coder writes from scratch:**
- **Entity class** (~200+ lines): water floatation, movement physics, paddling controls, passenger mounting/dismounting, collision, leash support, pickup item
- **Render state** (~30 lines): custom class extending `EntityRenderState` with fields for paddle angles, bubble angle, etc.
- **Renderer** (~120 lines): `submit()` with pose transforms, `extractRenderState()`, `createRenderState()`, name tag rendering
- **Registration** (~15 lines): `EntityType` and renderer

**All in all its just tedious from both sides**