# Oaster Device Verification Matrix

Each viewport must be deliberately designed and mounted. Verify layouts, navigation, focus/input, and performance per class.

| Target | Viewport / Mode | Navigation | Input | Status | Notes |
|---|---|---|---|---|---|
| Phone | Portrait | Bottom bar | Touch, gesture | Pending | Min 48dp targets, lower-third primary actions, edge-to-edge insets |
| Phone | Landscape | Bottom bar (adapted) | Touch | Pending | Polished layout, no stretched single-pane |
| Tablet | Portrait | Rail + adaptive panes | Touch | Pending | Two-pane list/detail where appropriate |
| Tablet | Landscape | Rail + expanded panes | Touch | Pending | Expanded capsule hero |
| Laptop/Desktop | Small window | Sidebar | Mouse, keyboard, hover | Pending | Resizable breakpoints, shortcuts |
| Laptop/Desktop | Large/full window | Sidebar + multi-column | Mouse, keyboard | Pending | Correct scaling and spacing |
| Android TV | 1080p | Focus-driven tab bar | D-pad remote only | Pending | Every element reachable; tab switch works with remote; clear focus |
| Android TV | 4K | Focus-driven tab bar | D-pad remote only | Pending | 10-foot typography/targets, no hover dependency |

## Verification criteria
- Correct adaptive layout mounted (not stretched).
- All interactive elements reachable and clearly focused (TV/keyboard).
- Tab switching works with TV remote without confusion.
- Smooth transitions and scrolling, no jank.
- Playback, mini-player, and now-playing behave correctly.
- Accessibility basics: contrast, labels, scaling.

Record issues and resolutions per row during implementation passes.
