# Oaster Component Specification

All components implement the Oaster liquid-glass design language, design tokens, and motion system. Components must be reusable, accessible, and adaptive across phone, tablet, desktop, and TV.

## 1. Surfaces

### GlassSurface
- Frosted/liquid-glass container with blur (`RenderEffect` on Android 12+, platform-equivalent on desktop), translucent fill, highlight gradient, 1dp rim stroke, subtle noise (2%).
- Props: elevation level, shape/radius, blur enabled override, content padding, click/focus handling.
- Fallback: opaque/semi-opaque elevated surface preserving hierarchy when blur unsupported.
- States: default, hover (desktop), pressed, focused (high-visibility ring), disabled.

### CapsuleHero
- Large pill-shaped hero (`radius.capsule`) for home/featured/now-playing highlights.
- Layers: blurred/translucent base, artwork/content layer, refraction highlight, optional subtle parallax.
- Responsive sizing: compact on phone, expanded on tablet/desktop, large safe-area aware on TV.
- Contains primary context (now playing/featured), quick actions, and clear affordances.

## 2. Navigation Suites
Adaptive navigation chosen by window size/input class:
- **Phone:** bottom navigation bar (glass), 3-5 destinations, labels clear, primary actions reachable in lower third.
- **Tablet:** left navigation rail, can expand in wide layouts; supports two-pane contexts.
- **Desktop/laptop:** sidebar navigation, multi-column content, hover and keyboard support, resizable window breakpoints.
- **TV:** focus-driven top/side tab bar optimized for D-pad; large targets and unmistakable focus.

Requirements:
- Consistent destination model across form factors.
- Tab switching on TV must work with remote D-pad (left/right/up/down as appropriate) with predictable focus order and visible focus state.
- No hover-dependent interactions.

## 3. Playback Components

### MiniPlayer / NowPlayingBar
- Persistent glass bar above navigation (phone/tablet) or anchored region (desktop/TV) when media active.
- Shows artwork, title/artist, play/pause, next, progress indicator; tap/enter expands to full now playing (shared-element transition).
- Accessible controls and focusable on TV/keyboard.

### Now Playing (Full Screen)
- Hero artwork, track metadata, seek bar, elapsed/remaining, shuffle/repeat, previous/play-pause/next, queue access, overflow actions.
- QueueSheet: reorder/add/remove/clear, current item highlighted, smooth drag/focus interactions.

## 4. Library Items
- **TrackRow:** artwork/thumb (optional by context), title, artist, duration, overflow; supports now-playing indicator.
- **AlbumCard / ArtistCard / PlaylistCard:** consistent radii, glass/imagery treatment, metadata hierarchy, focus/hover/press states.
- **Grids and lists:** lazy-loaded, stable keys, prefetch artwork.

## 5. Input and Controls
- **SearchBar + SearchResults:** debounced input, clear action, segmented/categorized results (tracks/albums/artists/playlists), empty/loading/error states.
- **Buttons:** primary (accent capsule), secondary (glass), tertiary/text; icon+label support.
- **Chips:** filters/toggles with selected and focus states.
- **Sliders:** progress/volume/equalizer with precise seek and keyboard/remote adjust behavior.
- **Toggles, dialogs, sheets:** glass language, clear hierarchy, scrim usage, accessible labels.

## 6. Feedback States
- **Loading:** skeleton/placeholders aligned to final layout.
- **Empty:** informative, actionable (e.g. scan library) with icon and concise text.
- **Error:** plain-language message, retry/action where possible.
- Every screen must define loading, empty, and error states.

## 7. Focus, Keyboard, and Remote
- Visible focus indicators on every focusable element (`focus.ring` tokens); never rely on color alone.
- Logical focus order; TV D-pad traversal must reach all interactive elements including tab switching.
- Desktop keyboard shortcuts: play/pause, next, previous, seek, volume, search, navigation.
- Hit targets: >=48dp touch, larger on TV (64dp+ preferred).

## 8. Icon System
- One professional icon pack only (Material Symbols Rounded or Lucide, locked globally).
- Consistent optical size and weight; custom SVG only for gaps.
- No emojis anywhere. All icons have content descriptions where meaningful.
