# Oaster Design Tokens

Design system version: 0.1 (draft for implementation)
Product: **Oaster** by **Cutozmie**  
Signature: liquid glass / frosted glass surfaces, capsule hero, smooth spring motion, professional restraint.

## 1. Color

### 1.1 Semantic roles
| Token | Purpose |
|---|---|
| `color.bg.canvas` | App background base |
| `color.bg.elevated` | Opaque elevated fallback surface |
| `color.glass.base` | Translucent glass fill |
| `color.glass.highlight` | Top/edge light refraction highlight |
| `color.glass.shadow` | Soft inner/outer depth tint |
| `color.glass.stroke` | Subtle rim stroke |
| `color.text.primary` | Primary text/icons |
| `color.text.secondary` | Secondary text/icons |
| `color.text.tertiary` | Metadata, disabled-adjacent labels (still accessible where used) |
| `color.accent.primary` | Primary interactive accent |
| `color.accent.onPrimary` | Content on accent |
| `color.state.focus` | High-visibility focus ring (TV/keyboard) |
| `color.state.success` | Positive feedback |
| `color.state.warning` | Caution |
| `color.state.error` | Error/destructive feedback |
| `color.scrim` | Overlays/sheets backdrop |

### 1.2 Light theme
| Token | Value | Notes |
|---|---:|---|
| `color.bg.canvas` | `#F3F5F7` | Cool neutral base for glass contrast |
| `color.bg.elevated` | `#FFFFFF` | Fallback opaque |
| `color.glass.base` | `#FFFFFF99` | 60% white, blur behind |
| `color.glass.highlight` | `#FFFFFFCC` | Edge/specular highlight |
| `color.glass.shadow` | `#0B122014` | 8% depth tint |
| `color.glass.stroke` | `#FFFFFF8C` | Rim separation |
| `color.text.primary` | `#12151A` | Contrast >= 7:1 on canvas |
| `color.text.secondary` | `#4A5565` | Contrast >= 4.5:1 |
| `color.text.tertiary` | `#667085` | Metadata; use large/bold contexts carefully |
| `color.accent.primary` | `#2F6BFF` | Cutozmie blue accent |
| `color.accent.onPrimary` | `#FFFFFF` | |
| `color.state.focus` | `#00A3FF` | 3dp+ visible ring on all devices |
| `color.state.success` | `#1F9D55` | |
| `color.state.warning` | `#B54708` | |
| `color.state.error` | `#D92D20` | |
| `color.scrim` | `#10182866` | 40% |

### 1.3 Dark theme
| Token | Value | Notes |
|---|---:|---|
| `color.bg.canvas` | `#0E1116` | Deep neutral |
| `color.bg.elevated` | `#171B22` | Fallback opaque |
| `color.glass.base` | `#1A223033` | 20% tinted glass |
| `color.glass.highlight` | `#FFFFFF1F` | Subtle specular |
| `color.glass.shadow` | `#00000066` | Depth |
| `color.glass.stroke` | `#FFFFFF24` | Rim |
| `color.text.primary` | `#F5F7FA` | |
| `color.text.secondary` | `#B8C0CC` | |
| `color.text.tertiary` | `#8A94A6` | |
| `color.accent.primary` | `#6EA8FF` | Accessible on dark glass |
| `color.accent.onPrimary` | `#081120` | |
| `color.state.focus` | `#7DD3FF` | High visibility on TV |
| `color.state.success` | `#47C27A` | |
| `color.state.warning` | `#FDB022` | |
| `color.state.error` | `#F97066` | |
| `color.scrim` | `#00000080` | 50% |

### 1.4 OLED true-black theme
| Token | Value | Notes |
|---|---:|---|
| `color.bg.canvas` | `#000000` | True black |
| `color.bg.elevated` | `#0A0A0A` | Minimal elevation separation |
| `color.glass.base` | `#FFFFFF14` | 8% for glass on black |
| `color.glass.highlight` | `#FFFFFF24` | |
| `color.glass.shadow` | `#00000099` | |
| `color.glass.stroke` | `#FFFFFF1F` | |
| `color.text.primary` | `#F7F7F7` | |
| `color.text.secondary` | `#B3B3B3` | |
| `color.text.tertiary` | `#8C8C8C` | |
| `color.accent.primary` | `#7AB4FF` | |
| `color.accent.onPrimary` | `#000000` | |
| `color.state.focus` | `#8AD8FF` | |
| `color.state.success` | `#57D38C` | |
| `color.state.warning` | `#FFC247` | |
| `color.state.error` | `#FF8A80` | |
| `color.scrim` | `#000000B3` | |

## 2. Elevation and Depth
Glass depth is expressed via blur + translucency + highlight/stroke, not heavy drop shadows.

| Token | Blur (dp) | Fill | Stroke | Shadow |
|---|---:|---|---|---|
| `elevation.glass.0` | 0 | transparent/none | none | none |
| `elevation.glass.1` | 12 | `glass.base` | 1dp `glass.stroke` | soft ambient 4dp @ 8% |
| `elevation.glass.2` | 20 | `glass.base` | 1dp `glass.stroke` | ambient 8dp @ 10% |
| `elevation.glass.3` | 28 | `glass.base` + highlight gradient | 1dp | ambient 12dp @ 12% |
| `elevation.hero` | 32 | layered glass + noise 2% | 1dp highlight edge | ambient 16dp @ 12% |

Fallback (no blur support): use `color.bg.elevated` with 96-98% opacity and same stroke/shadow tokens.

## 3. Blur and Glass Tokens
| Token | Value | Usage |
|---|---:|---|
| `blur.surface.sm` | 12dp | Chips, mini controls |
| `blur.surface.md` | 20dp | Cards, bars, sheets |
| `blur.surface.lg` | 28dp | Navigation, dialogs |
| `blur.surface.hero` | 32dp | Capsule hero |
| `glass.noise.opacity` | 0.02 | Subtle grain to reduce banding |
| `glass.highlight.gradient` | linear top-left to bottom-right, `glass.highlight` -> transparent 60% | Refraction cue |
| `glass.inner.stroke` | 1dp | Edge definition |

## 4. Spacing Scale
Base unit: 4dp.
| Token | Value |
|---|---:|
| `space.0` | 0 |
| `space.1` | 4 |
| `space.2` | 8 |
| `space.3` | 12 |
| `space.4` | 16 |
| `space.5` | 20 |
| `space.6` | 24 |
| `space.8` | 32 |
| `space.10` | 40 |
| `space.12` | 48 |
| `space.16` | 64 |

Layout gutters: phone 16dp, tablet 24dp, desktop 32dp, TV 48dp (safe overscan respected).

## 5. Radius Scale
| Token | Value | Usage |
|---|---:|---|
| `radius.xs` | 8dp | Small chips/inputs |
| `radius.sm` | 12dp | Buttons, list items |
| `radius.md` | 16dp | Cards |
| `radius.lg` | 24dp | Sheets, large cards |
| `radius.xl` | 32dp | Hero container elements |
| `radius.capsule` | 999dp | Capsule hero, pills, primary controls |

## 6. Typography Scale
Font family: platform-modern sans with high legibility (e.g. Inter/Roboto-flex equivalent available per platform; final bundled family chosen at implementation with license compatibility). Support dynamic type/font scaling.

| Token | Size / Line / Weight | Usage |
|---|---|---|
| `type.display` | 44/52, 600 | Hero headlines (desktop/TV scaled up) |
| `type.headline` | 32/40, 600 | Screen titles |
| `type.title` | 22/28, 600 | Section titles, now-playing track |
| `type.bodyLg` | 16/24, 500 | Primary content, track rows |
| `type.body` | 14/20, 400 | Secondary content |
| `type.label` | 13/16, 600 | Buttons, tabs, chips |
| `type.caption` | 12/16, 400 | Metadata, durations |

TV 10-foot scaling: multiply body/title sizes by ~1.25-1.5x depending on density and viewing distance; maintain contrast and focus clarity.

## 7. Iconography
- Single professional icon set across all targets (Material Symbols Rounded or Lucide; choose one at implementation and lock).
- Consistent stroke/weight/optical size (20/24/40dp grid contexts).
- No emojis. Custom SVGs only when set lacks coverage.
- Monochrome icon variant provided for themed/adaptive icons.

## 8. State and Accessibility Tokens
| Token | Value |
|---|---|
| `state.hover.overlay` | 8% accent/text overlay (desktop) |
| `state.pressed.overlay` | 12% overlay |
| `state.disabled.opacity` | 0.38 (ensure non-interactive; do not rely for essential info) |
| `focus.ring.width` | 3dp (TV: 4dp) |
| `focus.ring.offset` | 2dp |
| `hit.target.min` | 48dp (phone/tablet), 64dp+ preferred (TV) |

All themes must meet WCAG AA contrast for text and interactive indicators; focus states must be clearly visible on glass backgrounds.
