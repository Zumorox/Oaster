# Oaster Performance Checklist

Target: instant response, smooth motion (60fps minimum, 120fps where supported), zero buffering on local playback, no jank.

## Playback
- [ ] No buffering on local files (pre-open/prepare appropriately).
- [ ] Gapless playback verified for supported formats.
- [ ] Seek/scrub responds immediately without stutter or dropped audio.
- [ ] Audio focus handled correctly; no glitches on interruptions/resume.
- [ ] Background playback stable with MediaSession/notification controls (Android).

## UI and Rendering
- [ ] 60fps+ on mid-range hardware during scroll, tab switch, and transitions.
- [ ] 120fps behavior verified on capable displays.
- [ ] No dropped frames in shared-element transitions or hero/parallax effects.
- [ ] Glass/blur effects budgeted; fallback or caching used if needed.
- [ ] Animations use transform/opacity and spring tokens; no blocking work in composition.

## Data and Memory
- [ ] Library scan/indexing runs off main thread with progress reporting.
- [ ] Lazy lists/grids with stable keys and efficient item content.
- [ ] Artwork loading uses LRU memory/disk cache with appropriate sizing.
- [ ] Search input debounced; queries cancellable.
- [ ] No main-thread I/O or heavy decoding.

## Startup and Resources
- [ ] Cold start optimized (defer non-critical work).
- [ ] Memory footprint reasonable on mid-range devices and TV.
- [ ] Baseline profile generated and validated (Android).

## Profiling and Verification
- [ ] Profiled with Android Studio Profiler / Compose Layout Inspector / Macrobenchmark where available.
- [ ] Desktop profiling for window resize, large libraries, and playback.
- [ ] All items verified before declaring performance pass complete.

## Notes
Record device models, OS versions, measurements, and any regressions/fixes here during verification.
