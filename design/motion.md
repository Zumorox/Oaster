# Oaster Motion System

Principles: spring-based, physically natural, intentional, and respectful of reduce-motion preferences. No linear easing for UI transitions.

## 1. Motion Tokens

### 1.1 Springs
| Token | Damping ratio | Stiffness | Use |
|---|---:|---:|---|
| `motion.spring.snappy` | 0.82 | 500 | Buttons, toggles, micro-interactions |
| `motion.spring.standard` | 0.86 | 380 | Navigation, sheets, component state changes |
| `motion.spring.gentle` | 0.9 | 260 | Large surfaces, hero, shared elements |
| `motion.spring.settle` | 0.92 | 180 | Background/parallax settle, ambient motion |

### 1.2 Durations (for non-spring fades/blurs where needed)
| Token | Value | Use |
|---|---:|---|
| `motion.duration.fast` | 120ms | Icon/content crossfade |
| `motion.duration.base` | 180ms | Tab/content fades |
| `motion.duration.slow` | 260ms | Overlay/scrim fade |

All durations scale down or collapse to instant/near-instant when reduce-motion is enabled (platform-provided setting).

## 2. Patterns

### 2.1 Shared-element transitions
- List/grid item (track, album, artist, playlist card) to detail/now-playing: shared bounds + artwork morph using `motion.spring.gentle`.
- Container transforms preserve continuity; avoid abrupt cuts.
- Fallback: crossfade + subtle scale (0.98 -> 1.0) if shared elements unavailable.

### 2.2 Tab and destination transitions
- Phone bottom nav / tablet rail / desktop sidebar: crossfade content with slight vertical/horizontal offset (8dp) resolved by `motion.spring.standard`.
- TV tab focus movement: focus ring and tab highlight animate with `motion.spring.snappy`; content switch uses `motion.duration.base` crossfade to keep remote navigation predictable.

### 2.3 Capsule hero and parallax
- Hero entrance: gentle scale/opacity settle (`motion.spring.settle`).
- Subtle parallax on hero artwork/background layers (max 6-10dp offset) tied to scroll; disabled or minimized under reduce-motion.
- Now-playing hero transitions emphasize artwork continuity.

### 2.4 Sheets, dialogs, and mini-player
- Bottom sheets / queue sheet: spring slide + scrim fade (`motion.spring.standard`).
- Mini-player expand to full now-playing: shared-element/container transform.
- Dialogs: scale 0.96 -> 1.0 with fade, `motion.spring.snappy`.

### 2.5 Lists and feedback
- List item press: subtle scale to 0.98 and highlight overlay.
- Loading/skeleton: calm shimmer or fade pulse (low amplitude); avoid distracting loops.
- Progress/seek: immediate response, smooth animated thumb/track updates.

## 3. Performance Constraints
- Target 60fps minimum on mid-range hardware, 120fps where supported.
- No jank on scroll, tab switch, or shared-element transitions.
- Avoid animating expensive properties without hardware acceleration; prefer transform/opacity.
- Blur surfaces: cache/static where possible during motion; degrade gracefully if frame budget exceeded.
- Profile transitions with Compose tooling and device matrix before sign-off.

## 4. Reduce Motion
- Respect system reduce-motion/accessibility settings on each platform.
- Replace springs/parallax/shared-motion with simple crossfades or instant state changes.
- Maintain spatial clarity and focus visibility even when motion is reduced.
